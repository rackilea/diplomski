String error_msg = null;
Cookie [] cookies = request.getCookies();
for (Cookie cookie : cookies) {
    if ("errorMessage".equals(cookie.getName())) {
        error_msg =  cookie.getValue();
    }
}