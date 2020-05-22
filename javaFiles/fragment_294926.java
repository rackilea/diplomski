BasicClientCookie parseRawCookie(String rawCookie) throws Exception {
    String[] rawCookieParams = rawCookie.split(";");

    String[] rawCookieNameAndValue = rawCookieParams[0].split("=");
    if (rawCookieNameAndValue.length != 2) {
        throw new Exception("Invalid cookie: missing name and value.");
    }

    String cookieName = rawCookieNameAndValue[0].trim();
    String cookieValue = rawCookieNameAndValue[1].trim();
    BasicClientCookie cookie = new BasicClientCookie(cookieName, cookieValue);
    for (int i = 1; i < rawCookieParams.length; i++) {
        String rawCookieParamNameAndValue[] = rawCookieParams[i].trim().split("=");

        String paramName = rawCookieParamNameAndValue[0].trim();

        if (paramName.equalsIgnoreCase("secure")) {
            cookie.setSecure(true);
        } else {
            if (rawCookieParamNameAndValue.length != 2) {
                throw new Exception("Invalid cookie: attribute not a flag or missing value.");
            }

            String paramValue = rawCookieParamNameAndValue[1].trim();

            if (paramName.equalsIgnoreCase("expires")) {
                Date expiryDate = DateFormat.getDateTimeInstance(DateFormat.FULL)
                        .parse(paramValue);
                cookie.setExpiryDate(expiryDate);
            } else if (paramName.equalsIgnoreCase("max-age")) {
                long maxAge = Long.parseLong(paramValue);
                Date expiryDate = new Date(System.getCurrentTimeMillis() + maxAge);
                cookie.setExpiryDate(expiryDate);
            } else if (paramName.equalsIgnoreCase("domain")) {
                cookie.setDomain(paramValue);
            } else if (paramName.equalsIgnoreCase("path")) {
                cookie.setPath(paramValue);
            } else if (paramName.equalsIgnoreCase("comment")) {
                cookie.setPath(paramValue);
            } else {
                throw new Exception("Invalid cookie: invalid attribute name.");
            }
        }
    }

    return cookie;
}