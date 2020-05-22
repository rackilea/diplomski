@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String foo = request.getParameter("foo");
    String bar = request.getParameter("bar");
    String baz = request.getParameter("baz");

    boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));

    // ...

    if (ajax) {
        // Handle ajax (JSON or XML) response.
    } else {
        // Handle regular (JSP) response.
    }
}