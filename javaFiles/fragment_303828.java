protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String x = request.getParameter("x");
    String y = request.getParameter("y");

    PostProcessing pp = new PostProcessing(x, y);
    Thread t = new Thread(pp);
    t.start();

}