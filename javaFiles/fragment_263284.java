package com.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("name") != null && request.getParameter("name") != "") {
            request.setAttribute("message", "Hello " + request.getParameter("name"));
        }else {
            request.setAttribute("message", "");
        }

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}