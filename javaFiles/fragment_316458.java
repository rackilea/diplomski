import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.jetty.server.session.AbstractSession;
import org.eclipse.jetty.server.session.HashSessionIdManager;
import org.eclipse.jetty.server.session.HashSessionManager;

/**
 * Allows the WebAppContext to check the server's SessionIdManager before creating a new session
 * so that WebAppContext can share session contents for each client rather than just session ids.
 */
public class CrossContextSessionManager extends HashSessionManager {

  // Number of seconds before the user is automatically logged out of an idle webapp session
  private int defaultSessionTimeout = 1800;

  /**
   * Check for an existing session in the session id manager by the requested id.
   * If no session has that id, create a new HttpSession for the request.
   */
  @Override
  public HttpSession newHttpSession(HttpServletRequest request) {
    AbstractSession session = null;

    String requestedId = request.getRequestedSessionId();
    if (requestedId != null) {
      String clusterId = getSessionIdManager().getClusterId(requestedId);
      Collection<HttpSession> sessions = ((HashSessionIdManager) getSessionIdManager()).getSession(clusterId);
      for (HttpSession httpSession : sessions) {
        session = (AbstractSession) httpSession;
        break;
      }
    }

    if (session == null) {
      session = newSession(request);
      session.setMaxInactiveInterval(defaultSessionTimeout);
      addSession(session,true);
    }

    return session;
  }
}