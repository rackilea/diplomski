CookieStore cookieStore = new BasicCookieStore();

DefaultHttpClient client1 = new DefaultHttpClient();
client1.setCookieStore(cookieStore);
HttpGet httpGet1 = new HttpGet("...");
HttpResponse response1 = client1.execute(httpGet1);

DefaultHttpClient client2 = new DefaultHttpClient();
client2.setCookieStore(cookieStore);
HttpGet httpGet2 = new HttpGet("...");
HttpResponse response2 = client2.execute(httpGet2);