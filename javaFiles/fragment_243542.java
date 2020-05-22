protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Check tempetaure</title></head>");
        out.println("<body>");
        out.println("<form action='CheckTemperature' method='post'>");

        out.println("<input type=\"submit\" value=\"Check temperature\" name=\"button\"/>");
        out.println("<form />");
        out.println("<input type=\"submit\" value=\"Get AC state\" name=\"button\"/>");
        out.println("<input type=\"submit\" value=\"Turn ON AC\" name=\"button\"/>");
        out.println("<input type=\"submit\" value=\"Turn OFF AC\" name=\"button\"/>");
        out.println("</body>");
        out.println("</html>");     
    }