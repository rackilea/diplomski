private static final CookieStore sCookieStore;

static {
  sCookieStore = new CookieStore();
  sCookieStore.setSize(1000);
  sCookieStore.addToBlacklist("bing.com");
  sCookieStore.readCookiesFromFile("/tmp/cookies.txt");
}