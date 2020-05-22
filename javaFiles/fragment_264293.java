import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.session.SessionHandler;

public class MySessionHandler extends SessionHandler {

    @Override
    public void doScope(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession oldSession = request.getSession(false);
        super.doScope(target, baseRequest, request, response);
        HttpSession newSession = request.getSession(false);

        if (newSession != null && oldSession != newSession) {
            getSessionManager().complete(newSession);
        }
    }
}