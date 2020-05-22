public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
{
    String[] params = request.getParameterValues("productID");
    String productID = params[0];
    ...
}