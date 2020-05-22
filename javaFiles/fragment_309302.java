package com.server.testing;

import java.io.IOException;

public class Sample extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {

            String city = request.getParameter("cities");
            String numbers = request.getParameter("matrix");

            String[] args = new String[2];
            args[0] = city;
            args[1] = numbers;
            TSPNearestNeighbour.main(args);

    }
}