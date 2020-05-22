HttpPost httppost = new HttpPost(postData); 
CookieStore cookieStore = new BasicCookieStore(); 
BasicClientCookie cookie = new BasicClientCookie("JSESSIONID", getSessionId());

//cookie.setDomain("your domain");
cookie.setPath("/");

cookieStore.addCookie(cookie); 
client.setCookieStore(cookieStore); 
response = client.execute(httppost);