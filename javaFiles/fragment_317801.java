package com.example.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

   private static final long serialVersionUID = -3808675281434686897L;

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       String requestColor = null;
       String requestTxtName = null;

       PrintWriter out = response.getWriter();
       MySessionListener listener = new MySessionListener();
       HttpSession session = request.getSession();

       if (session.isNew()) {
           //these are request parameters sent from html form
           requestColor = request.getParameter("color");
           requestTxtName = request.getParameter("txtName");

           //save the attributes in session in order to use them later
           session.setAttribute("sessionColor", requestColor);
           session.setAttribute("sessionTxtName", requestTxtName);
       }
       else {
           //get the previously stored attributes from session
           String color = (String) session.getAttribute("sessionColor");
           String name = (String) session.getAttribute("sessionTxtName");

           //session info
           out.println("session already existed");

           if (color != null && name != null) {
               out.println("Name: " + name);
               out.println("Color: " + color);

               out.println("Session count: " + listener.getSessionCount());
           }
       }
   }
}