@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InputStream is = request.getInputStream();
        //this convertStreamToString is my internal method. You can have any your own conversion API
        System.out.println("----"+convertStreamToString(is)); 
        processRequest(request, response);
    }