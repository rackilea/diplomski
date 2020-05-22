public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath( "/" );
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }