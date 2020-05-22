package com.myapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet { 

@Override
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {                     

    if(request.getRequestURI().equals("/abc")) {
        new ABC().callabc();
    } else if(request.getRequestURI().equals("/def")) {
        new DEF().calldef();
    }

    //ADD Code here to Send Ack back to the caller

   // Ack Code Ends here
  }
}