CookieManager cookieManager = new CookieManager();
cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
CookieHandler.setDefault(cookieManager);
// Creates url for the given string
URL url = null;
try {
    url = new URL("http://localhost/");
    // Opens a connection with the url specified and returns URLConnection object
    URLConnection urlConnection = url.openConnection();
    // Gets the contents from this url specifies
    urlConnection.getContent();
} catch (MalformedURLException | IOException e) {
    e.printStackTrace();
}
// Returns the cookie store(bunch of cookies)
CookieStore cookieStore = cookieManager.getCookieStore();
// Getting cookies which returns in the form of List of type HttpCookie
List<HttpCookie> listOfcookies = cookieStore.getCookies();
for (HttpCookie httpCookie: listOfcookies) {
    System.out.println("Cookie Name : " + httpCookie.getName() + " Cookie Value : " + httpCookie.getValue());
}