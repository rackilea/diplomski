protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //code
    PrintWriter out=response.getWriter();
    out.println("hi");
    out.flush(); 
    out.close();