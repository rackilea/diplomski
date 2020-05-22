package com.example;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

public class TestOrderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
        int amount = 0;
        try {
            amount = Integer.parseInt(request.getParameter("itemAmount"));
        } catch (NumberFormatException e) {
            // do something or whatever
        }

        if ((amount > 0) && (amount < 100)) {   // an amount is OK
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {                                // invalid amount
            // Set some error message as a request attribute.
            if (amount <= 0) {
                request.setAttribute("errorMessage", "Please submit an amount of at least 1");
            } 
            if (amount > 100){
                request.setAttribute("errorMessage", "Amount of items ordered is too big. No more than 100 is currently available.");
            }
            // get back to order.jsp page using forward
            request.getRequestDispatcher("/order.jsp").forward(request, response);
        }
    }
}