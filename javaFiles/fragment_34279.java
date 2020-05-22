...

import javax.servlet.http.HttpServletRequest
import net.liftweb.http.provider.servlet.HTTPRequestServlet
import org.eclipse.jetty.server.{Request=>JettyReq}

class Boot {
  def boot {

    def servletRequest(req: Req): Box[HttpServletRequest] = for {
      inner <- Box.asA[HTTPRequestServlet](req.request)
    } yield inner.req

    def setCookieDomain(req: Req) = {

      servletRequest(req).foreach { r =>
      {
        val sessionManager = r.asInstanceOf[JettyReq].getSessionManager
        val cookieConfig = sessionManager.getSessionCookieConfig

        cookieConfig.setDomain(".subdomain.com")
      }
      }
    }

    LiftRules.onBeginServicing.append(setCookieDomain)

    ...
  }
}