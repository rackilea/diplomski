protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    …
    String xml = "some xml";
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/xml");
    PrintWriter out = resp.getWriter();
    out.write(xml); }