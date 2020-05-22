protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Map<String, String> errors = new HashMap<String, String>();

    String origin = request.getParameter("origin");
    if (origin does not validate) {
       errors.put("origin", "Put error message here.");
    }

    // Repeat for all parameters.

    if (errors.isEmpty()) {
        // No errors, redirect to Amtrak.
        response.sendRedirect("http://amtrak.com");
    } else {
        // Put errors in request scope and forward back to JSP.
        request.setAttribute("errors", errors);
        request.getRequestDispatcher("FareFinder.jsp").forward(request, response);
    }
}