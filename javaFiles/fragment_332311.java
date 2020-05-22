import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;


public class TunnelingDispatcher extends HttpServletDispatcher {

@Override
protected void service(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse) throws ServletException,
        IOException {
    String method = httpServletRequest.getParameter("method");
    if (method == null) {
        method = httpServletRequest.getMethod();
    } else {
        method = method.toUpperCase();
    }
    service(method, httpServletRequest, httpServletResponse);
}

}