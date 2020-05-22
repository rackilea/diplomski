public final class CookieCsrfTokenRepository implements CsrfTokenRepository

private String cookiePath;

 @Override
public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
    String tokenValue = token == null ? "" : token.getToken();
    Cookie cookie = new Cookie(this.cookieName, tokenValue);
    cookie.setSecure(request.isSecure());
    // cookie.setPath(getCookiePath(request));
    if (this.cookiePath != null && !this.cookiePath.isEmpty()) {
        cookie.setPath(this.cookiePath);
    } else {
        cookie.setPath(getRequestContext(request));
    }

    if (token == null) {
        cookie.setMaxAge(0);
    } else {
        cookie.setMaxAge(-1);
    }
    if (cookieHttpOnly && setHttpOnlyMethod != null) {
        ReflectionUtils.invokeMethod(setHttpOnlyMethod, cookie, Boolean.TRUE);
    }

    response.addCookie(cookie);
}

public void setCookiePath(String path) {
    this.cookiePath = path;
}

public String getCookiePath() {
    return this.cookiePath;
}