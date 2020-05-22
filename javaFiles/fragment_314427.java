protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    …
    String xml = "some xml";
    resp.setContentType("text/html; charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.write(xml); }