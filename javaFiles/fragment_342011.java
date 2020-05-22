import java.io.*;
import java.util.*;
import org.jruby.embed.ScriptingContainer;
import org.apache.commons.codec.binary.Base64;
import javax.servlet.*;
import javax.servlet.http.*;

public class process extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   HttpSession session = request.getSession(true);

    PrintWriter out = response.getWriter();
    Cookie[] cookies = request.getCookies();

    for(int i=0; i<cookies.length; i++) {
      Cookie cookie = cookies[i];

      // base64 decode, then un-marshall ruby style...
      // finally figure out what to do with our session secret key
      if(cookie.getName().equals("_session_id")) {
        ScriptingContainer container = new ScriptingContainer();
        container.setWriter(out);
        container.runScriptlet("require 'base64'; puts \"" + cookie.getValue() + "\"; " +
                              "puts Marshal.load(Base64.decode64(\"" + cookie.getValue() + "\")).to_s; ");
      }                       

    } 

}     
}