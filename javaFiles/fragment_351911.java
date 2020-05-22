protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // Verify login, and get the username. Assume it's josh

    Cookie cookie = new Cookie("username", "josh");
    cookie.setMaxAge(60*60*24); // 24 hours for expiry
    response.addCookie(cookie);

}