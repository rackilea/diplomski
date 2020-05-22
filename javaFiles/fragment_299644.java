public Cookie(String name, String value, String domain, String path, Date expiry,
      boolean isSecure, boolean isHttpOnly)


driver.manage().addCookie(
                    new Cookie("test", "test", "google.com", "/", null, false,false));