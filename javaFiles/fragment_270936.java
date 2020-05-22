protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws IOException {

    /* ... */

    response.sendRedirect("http://example.com/your/url#hash");
}