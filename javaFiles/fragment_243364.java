package de.java2enterprise.onlineshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() { }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        final String email = request.getParameter("email");
        final String password = request.getParameter("password");

        final PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<br> Ihre Eingaben");
        out.println("<br> EMail: " + email);
        out.println("<br> EMail: " + password);
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}