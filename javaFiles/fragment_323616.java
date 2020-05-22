import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class word extends HttpServlet
{
    public void service(HttpServletRequest req , HttpServletResponse res)
    {
    res.setContentType("application/msword");
    try
    {
        PrintWriter out=res.getWriter();
        out.println("That's what I go to school for.. :-p ");

    }catch(Exception e)
    {}
}