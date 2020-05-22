// Method to handle POST method request.
public void doPost(HttpServletRequest request,
                   HttpServletResponse response)
        throws ServletException, IOException {
    uri_param = request.getParameter("uri_param");
    System.out.println("Parameter uri_param: " + uri_param);
    doGet(request, response);
}