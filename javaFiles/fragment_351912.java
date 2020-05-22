protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Cookie[] cookies = request.getCookies();

    String username = null;

    for (Cookie c : cookies) {
        if ("_username".equals(c.getName())) {
            username = c.getValue();
            break;
        }
    }

    if (username == null) {
        // Not Logged in. Redirect to Login
    }

    // User Logged In. Proceed
}