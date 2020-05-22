Cookie cookie = Servlets.getCookie(request, "foo");

if (cookie != null) {
    cookie.setValue(newValue);
    response.addCookie(cookie);
}