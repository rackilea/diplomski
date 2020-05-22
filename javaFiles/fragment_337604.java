package test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class PrintServlet extends HttpServlet {

     static {
       System.out.println("STACKOVERFLOW:> I've been loaded!");
     }

     public void doGet(HttpServletRequest request,
              HttpServletResponse response) throws ServletException, IOException {
         PrintWriter out = response.getWriter();
         out.println("Hello World");
     }
}