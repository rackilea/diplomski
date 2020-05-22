Map<String, NewCookie> cookies = response.getCookies();
Invocation.Builder ib = baseTarget.request();
for (NewCookie cookie: cookies.values()) {
    ib.cookie(cookie.toCookie());
}
Response response = ib.get();