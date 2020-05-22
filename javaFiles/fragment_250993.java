public static final String HTMLUNIT_COOKIE_POLICY = CookiePolicy.BROWSER_COMPATIBILITY; //default
   final CookieSpec spec = registry_.getCookieSpec(HTMLUNIT_COOKIE_POLICY);

   for (final org.apache.http.cookie.Cookie cookie : all) {
        if (spec.match(cookie, cookieOrigin)) {
            matches.add(cookie);
        }
    }