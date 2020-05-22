package org.lds.stack.web.spring.i18n;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

/**
 * This locale resolver provides the ability to define a list of resolvers from which to determine
 * the locale.  This allows us to give preference to certain locale resolution schemes by putting
 * them earlier in the list.  
 * <p/>
 * 
 * The order of resolvers from which to find the given locale (or set a specified locale) could be
 * defined in the spring context file with something like:
 * 
 * <pre>
 * &lt;bean id=&quot;localeResolver&quot; class=&quot;org.lds.stack.web.spring.i18n.ChainedLocaleResolver&quot;&gt;
 *      &lt;property name=&quot;localeResolvers&quot;&gt;
 *          &lt;list&gt;
 *              &lt;bean class=&quot;org.lds.stack.web.spring.i18n.UrlLocaleResolver&quot; /&gt;
 *              &lt;bean class=&quot;org.lds.stack.web.spring.i18n.NoDefaultSessionLocaleResolver&quot; /&gt;
 *              &lt;bean class=&quot;org.lds.stack.web.spring.i18n.NoDefaultCookieLocaleResolver&quot;&gt;
 *                  &lt;property name=&quot;cookieMaxAge&quot; value=&quot;31536000&quot;/&gt;
 *              &lt;/bean&gt;
 *              &lt;bean class=&quot;org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver&quot; /&gt;
 *              &lt;bean class=&quot;org.springframework.web.servlet.i18n.FixedLocaleResolver&quot; /&gt;
 *          &lt;/list&gt;
 *      &lt;/property&gt;
 *  &lt;/bean&gt;
 * </pre>
 * 
 * This allows you to remove, or re-order the locale resolution schemes to meet your needs.
 * Also note that the id of localeResolver is significant.  The Spring Framework knows to use this
 * resolver as the LocaleResolver by virtue of the id being "localeResolver".
 * <p/>
 * 
 * NOTE: If the default resolver order, shown above, will work for your application, then you can 
 * skip this verbose definition by utilizing the stack-web namespace handler, providing any exposed 
 * attribute values for minor customizations.  The namespace handler is defined as follows:
 * 
 * <pre>
 * &lt;stack-web:locale-resolver /&gt;
 * </pre>
 * 
 * Additionally, in order to change the locale based on a url parameter, you can configure a
 * LocaleChangeInterceptor, which will call the set method of all of the locales in the chained
 * resolver, so that they can be found when resolveLocale(...) is called on them.  
 * <p/>
 * 
 * The interceptor configuration might look as follows:
 * <pre>
 *  &lt;mvc:interceptors&gt;
 *      &lt;bean id=&quot;localeChangeInterceptor&quot; class=&quot;org.springframework.web.servlet.i18n.LocaleChangeInterceptor&quot; /&gt;
 *  &lt;/mvc:interceptors&gt;
 * </pre>
 */
public class ChainedLocaleResolver implements LocaleResolver {

    private List<LocaleResolver> localeResolvers;

    public ChainedLocaleResolver() {
        //if anything other than this default order or set is desired, the list of resolvers
        //to be chained should be set up in the bean definition as shown above
        localeResolvers = new ArrayList<LocaleResolver>();
        //TODO: Is the Url resolver necessary if we have an interceptor that changes the locale from the url?
        localeResolvers.add(new UrlLocaleResolver());
        localeResolvers.add(new NoDefaultSessionLocaleResolver());
        NoDefaultCookieLocaleResolver cookieLocaleResolver = new NoDefaultCookieLocaleResolver();
        cookieLocaleResolver.setCookieMaxAge(31536000);
        localeResolvers.add(cookieLocaleResolver);
        //TODO: may need to create a NoDefault, but that seems difficult as the implementation is provided
        //by the javax.servlet, ..., Also, maybe we could just remove the fixedLocaleResolver, as this one
        //gets the default, and then if people did not use this one, they could add the fixed one back in.
        localeResolvers.add(new AcceptHeaderLocaleResolver());
        localeResolvers.add(new FixedLocaleResolver());
    }

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        Locale locale = null;
        for (LocaleResolver resolver : getLocaleResolvers()) {
            locale = resolver.resolveLocale(request);
            if (locale != null) {
                return locale;
            }
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        for (LocaleResolver resolver : getLocaleResolvers()) {
            try {
                resolver.setLocale(request, response, locale);
            } catch (UnsupportedOperationException uoe) {}
        }
    }

    public List<LocaleResolver> getLocaleResolvers() {
        return localeResolvers;
    }
    public void setLocaleResolvers(List<LocaleResolver> localeResolvers) {
        this.localeResolvers = localeResolvers;
    }
}