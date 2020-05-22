protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Map<String, String> messages = new HashMap<String, String>();
    request.setAttribute("messages", messages);

    String foo = request.getParameter("foo");
    String bar = request.getParameter("bar");

    if (foo == null || foo.trim().isEmpty()) {
        messages.put("foo", "Please enter this field");
    }

    if (bar == null || bar.trim().isEmpty()) {
        messages.put("bar", "Please enter this field");
    }

    if (messages.isEmpty()) {
        YourMailer.send(createTemplate(foo, bar), mailto);
        messages.put("succes", "Mail successfully sent!");
    }

    // At end, forward request to JSP page for display:
    request.getRequestDispatcher("pagename.jsp").forward(request, response);
}