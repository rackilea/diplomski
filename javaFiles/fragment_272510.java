HttpClient client = new DefaultHttpClient();
HttpPost post = new HttpPost("http://192.168.178.163:8080/login/");
CookieStore cookieStore = new BasicCookieStore();
HttpContext context = new BasicHttpContext();
context.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
...
HttpResponse response = client.execute(post, context);
List<Cookie> cookies = cookieStore.getCookies();
CookieMonster.eat(cookies); // :)