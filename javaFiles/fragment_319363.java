public void delete(MyType instance) {
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (Long.valueOf(cookie.getValue()).equals(instance.getId())) {
                cookie.setValue(null);
                cookie.setMaxAge(0);
                cookie.setPath(theSamePathAsYouUsedBeforeIfAny);
                response.addCookie(cookie);
            }
        }
    }
}