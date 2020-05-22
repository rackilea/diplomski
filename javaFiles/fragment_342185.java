import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 

public class CookieTest extends HttpServlet 
{     
    public void doGet(HttpServletRequest req, HttpServletResponse res) 
    throws ServletException, IOException 
        { 
            res.setContentType("text/html"); 
            PrintWriter out = res.getWriter(); 

            //Get the current session ID by searching the received cookies. 
            String cookieid = null; 
            Cookie[] cookies = req.getCookies(); 

            if (cookies != null) 
            { 
                for (int i = 0; i < cookies.length; i++) 
                { 
                    if (cookies[i].getName().equals("REMOTE_USER")) 
                    { 
                         cookieid = cookies[i].getValue(); 
                         break; 
                    } 
                } 
            } 
            System.out.println("Cookie Id--"+cookieid); 

            //If the session ID wasn't sent, generate one. 
            //Then be sure to send it to the client with the response. 

        } 

}