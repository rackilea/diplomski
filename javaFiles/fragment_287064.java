// Prepare download here.
// ...

// Once finished, set cookie and stream download to response.
Cookie cookie = new Cookie("download", request.getParameter("token"));
cookie.setPath("/");
response.addCookie(cookie);
// ...