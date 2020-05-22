import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.util.Map.Entry;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FlashScopeInterceptor implements HandlerInterceptor {

    public static final String DEFAULT_ATTRIBUTE_NAME = "flashScope";
    public static final String DEFAULT_SESSION_ATTRIBUTE_NAME = FlashScopeInterceptor.class.getName();
    public static final int DEFAULT_RETENTION_COUNT = 2;

    private String sessionAttributeName = DEFAULT_SESSION_ATTRIBUTE_NAME;
    private String attributeName = DEFAULT_ATTRIBUTE_NAME;
    private int retentionCount = DEFAULT_RETENTION_COUNT;

    /**
     * Unbinds current flashScope from session. Rolls request's flashScope to
     * the next scope. Binds request's flashScope, if not empty, to the session.
     * 
     */

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        if (request.getSession( false ) != null)
        {
            request.getSession().removeAttribute( this.sessionAttributeName );
        }
        Object requestAttribute = request.getAttribute( this.attributeName );
        if (requestAttribute instanceof MultiScopeModelMap)
        {
            MultiScopeModelMap attributes = (MultiScopeModelMap) requestAttribute;
            if (!attributes.isEmpty())
            {
                attributes.next();
                if (!attributes.isEmpty())
                {
                    request.getSession( true ).setAttribute( this.sessionAttributeName, attributes );
                }
            }
        }
    }

    /**
     * merge modelAndView.model['flashScope'] to current flashScope
     */
    @Override
    public void postHandle( HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        if (modelAndView != null)
        {
            Map<String, Object> modelFlashScopeMap = null;
            for (Iterator<Entry<String, Object>> iterator = ((Map<String, Object>) modelAndView.getModel()).entrySet()
                    .iterator(); iterator.hasNext();)
            {
                Entry<String, Object> entry = iterator.next();
                if (this.attributeName.equals( entry.getKey() ) && entry.getValue() instanceof Map)
                {
                    if (modelFlashScopeMap == null)
                    {
                        modelFlashScopeMap = (Map) entry.getValue();
                    }
                    else
                    {
                        modelFlashScopeMap.putAll( (Map) entry.getValue() );
                    }
                    iterator.remove();
                }
                else if (entry.getKey().startsWith( this.attributeName + "." ))
                {
                    String key = entry.getKey().substring( this.attributeName.length() + 1 );
                    if (modelFlashScopeMap == null)
                    {
                        modelFlashScopeMap = new HashMap<String, Object>();
                    }
                    modelFlashScopeMap.put( key, entry.getValue() );
                    iterator.remove();
                }
            }
            if (modelFlashScopeMap != null)
            {
                MultiScopeModelMap flashScopeMap;
                if (request.getAttribute( this.attributeName ) instanceof MultiScopeModelMap)
                {
                    flashScopeMap = (MultiScopeModelMap) request.getAttribute( this.attributeName );
                }
                else
                {
                    flashScopeMap = new MultiScopeModelMap( this.retentionCount );
                }
                flashScopeMap.putAll( modelFlashScopeMap );
                request.setAttribute( this.attributeName, flashScopeMap );
            }
        }
    }

    /**
     * binds session flashScope to current session, if not empty. Otherwise cleans up empty
     * flashScope
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession( false );
        if (session != null)
        {
            Object sessionAttribute = session.getAttribute( this.sessionAttributeName );
            if (sessionAttribute instanceof MultiScopeModelMap)
            {
                MultiScopeModelMap flashScope = (MultiScopeModelMap) sessionAttribute;
                if (flashScope.isEmpty())
                {
                    session.removeAttribute( this.sessionAttributeName );
                }
                else
                {
                    request.setAttribute( this.attributeName, flashScope );
                }
            }
        }
        return true;
    }
}