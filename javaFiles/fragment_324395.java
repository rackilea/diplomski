protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  Enumeration<String> parameterNames = reqest.getParameterNames();

  while (parameterNames.hasMoreElements()) {

    String paramName = parameterNames.nextElement();
    String[] paramValues = req.getParameterValues(paramName);
    // do stuff with your values here

  }
}