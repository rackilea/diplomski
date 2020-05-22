Cookie cookie = cookies[i];
if (cookie.getName().equals("Name")) {
    String cookieName  = cookie.getName();
    String cookieValue = cookie.getValue();
    out.print(cookieValue);
}