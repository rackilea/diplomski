private void destroyCookie(Cookie cookie, HttpServletResponse response) {
    if (cookie != null) {
        response.setContentType("text/html");
        cookie.setPath("/");
        cookie.setValue("notValidSession");
        cookie.setComment("EXPIRING COOKIE at " + System.currentTimeMillis());
        cookie.setVersion(0);
        //I've configured the domain on the custom-params-service.xml on JBoss
        cookie.setDomain( AppUtils.getJndiConfig("SSOCookieDomain") ); 
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}