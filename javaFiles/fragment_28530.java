public class LocaleResolver implements net.jawr.web.resource.bundle.locale.LocaleResolver {

    public LocaleResolver() {}

    public String resolveLocaleCode(HttpServletRequest request) {
        //Lookup component manually as not part of SEAM lifecycle
        LocaleSelector localeSelector = (LocaleSelector)Contexts.getSessionContext().get(LocaleSelector.class);
        if(localeSelector!=null){
            return localeSelector.getLocaleString();
        }else{
            return request.getLocale().toString();
        }   
    }
}