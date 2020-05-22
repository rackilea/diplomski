import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

public class ShiroSessionManager extends DefaultWebSessionManager
{
    @Override
    protected void onStart(Session session, SessionContext context)
    {
        if (isSessionIdCookieEnabled())
        {
            HttpServletRequest request = WebUtils.getHttpRequest(context);
            HttpServletResponse response = WebUtils.getHttpResponse(context);

            removeSessionCookieForFullDomain(request, response);
        }

        super.onStart(session, context);
    }

    private void removeSessionCookieForFullDomain(HttpServletRequest request, HttpServletResponse response)
    {
        Cookie sessionCookie = getSessionIdCookie();
        Cookie cookie = new SimpleCookie(sessionCookie.getName());

        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setComment(sessionCookie.getComment());

        // Setting the domain to null means use the fully qualified domain name
        cookie.setDomain(null);

        cookie.setMaxAge(sessionCookie.getMaxAge());
        cookie.setPath(sessionCookie.getPath());
        cookie.setValue(sessionCookie.getValue());
        cookie.setVersion(sessionCookie.getVersion());

        cookie.removeFrom(request, response);
    }
}