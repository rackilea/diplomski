BasicHttpParams params = new BasicHttpParams();
String[] dateFormats = {"EEE, dd-MMM-yy HH:mm:ss zzz"};
params.setParameter(CookieSpecPNames.DATE_PATTERNS,Arrays.asList(dateFormats));

DefaultHttpClient httpClient = new DefaultHttpClient(params);
httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY,CookiePolicy.NETSCAPE);//explicitly set the cookie policy

HttpContext context = new BasicHttpContext();
CookieStore cookieStore = new BasicCookieStore();
context.setAttribute(ClientContext.COOKIE_STORE,cookieStore);


BlueClient myClient = new BlueClient("http://myHost.com/",httpClient,context);

myClient.doLogin("user","pass");
myClient.getMyStuff();//now i get my stuff !
myClient.doLogout();