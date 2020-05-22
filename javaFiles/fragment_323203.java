public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("application/json");
    String output = json.toString();
    PrintWriter writer = response.getWriter();
    writer.write(output);
    writer.close();
}