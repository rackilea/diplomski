HttpClient httpClient = new DefaultHttpClient();

//parse name/value from mCookies[0]. If you have more than one cookie, a for cycle is needed.
CookieStore cookieStore = new BasicCookieStore();
Cookie cookie = new BasicClientCookie("name", "value");
cookieStore.addCookie(cookie);

HttpContext localContext = new BasicHttpContext();
localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);

HttpGet httpGet = new HttpGet("http://www.domain.com/"); 

HttpResponse response = httpClient.execute(httpGet, localContext);