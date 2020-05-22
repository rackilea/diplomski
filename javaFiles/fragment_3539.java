protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    // response.setContentType("text/html");
    request.setAttribute("msg", "Bloody Hell");
    request.getRequestDispatcher("/index.jsp").include(request, response);
}