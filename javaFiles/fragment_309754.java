System.out.println(getCookieByName(request, "telco").getValue());


/**
 * Find a specific HTTP cookie in a request.
 * 
 * @param request
 *            The HTTP request object.
 * @param name
 *            The cookie name to look for.
 * @return The cookie, or <code>null</code> if not found.
 */
protected Cookie getCookieByName(HttpServletRequest request, String name) {
    if (request.getCookies() == null) {
        return null;
    }
    for (int i = 0; i < request.getCookies().length; i++) {
        if (request.getCookies()[i].getName().equals(name)) {
            return request.getCookies()[i];
        }
    }
    return null;
}