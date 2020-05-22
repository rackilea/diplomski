private static  syncCookies_android() {

    // // Get cookies from the URLSession 
    var javaCookieManager = java.net.CookieHandler.getDefault();
    var cookieStore = javaCookieManager.getCookieStore();
    var cookieList = cookieStore.getCookies();

    //Set the cookie for the webview
    var context = application.android.context;
    var cookieSyncManager = android.webkit.CookieSyncManager.createInstance(context);
    var cookieManager = android.webkit.CookieManager.getInstance();

    cookieManager.setAcceptCookie(true);
    cookieManager.removeSessionCookie();
    for (var cookie of cookieList.toArray()) {
         cookieManager.setCookie(config.apiServerURL, cookie.toString());
    }
    cookieSyncManager.sync();
    cookieManager.flush();
}