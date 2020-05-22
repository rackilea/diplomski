protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //String path = request.getPathInfo();
    //if(path == null) return;
    //String []p = path.split("/");
    //if( !path.endsWith("licenseValidation.html") )
    //request.getRequestDispatcher("/auth/licenseValidation.html").forward(request, response);
    response.sendRedirect( request.getContextPath() + "/auth/licenseValidation.html" );
}