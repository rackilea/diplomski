try {
   return dbConnection.createStatement();
 }   catch(SQLException sqle) {
    // TODO SQL Exception
    request.setAttribute("ex", sqle);
    RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
    rd.forward(request, response);
  }