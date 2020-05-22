if(set.next()) {
        userName = set.getString("FirstName");
        Email = set.getString("Email");

        // start the session and take to his homepage
        HttpSession session = request.getSession();
        session.setAttribute("UserName", userName);
        session.setMaxInactiveInterval(900); // If the request doesn't come withing 900 seconds the server will invalidate the session
        RequestDispatcher rd = request.getRequestDispatcher("portfolio_one.jsp");
        rd.forward(request, response); // forward to the user home-page
    } else {
        // turn to the error page
        response.sendRedirect("LoginFailure.jsp");
    }