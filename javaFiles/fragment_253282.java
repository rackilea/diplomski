public void delete(MyType instance) {
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("test")) {
                cookie.setValue(null);
                cookie.setMaxAge(0);
                cookie.setPath(theSamePathAsYouUsedBeforeIfAny);
                response.addCookie(cookie);
            }
        }
    }
}