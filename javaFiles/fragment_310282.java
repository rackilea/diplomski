Cookie cookie = Servlets.getCookie(request, "foo");

if (cookie != null) {
    cookie.setMaxAge(0);
    cookie.setValue(null);
    response.addCookie(cookie);
}