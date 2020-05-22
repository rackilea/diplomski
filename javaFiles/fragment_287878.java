public class AppCompatCookieActivity extends AppCompatActivity {

   @Override
   public void onResume() {
      super.onResume();
      // start cookie syncing for pre-lollipop devices
      if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
         CookieSyncManager.getInstance().startSync();
      }
   }

   @Override
   public void onPause() {
      // stop cookie syncing for pre-lollipop devices
      if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
         CookieSyncManager.getInstance().sync();
      }
      super.onPause();
   }

   public final void enableCookies(WebView webView) {
      // enable javascript (has security implications!)
      webView.getSettings().setJavaScriptEnabled(true);

      // enable cookies.
      CookieManager.getInstance().setAcceptCookie(true);

      // enable fileScheme cookies (has security implications!)
      // it is recommended to comment this out should you find it not necessary
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
         CookieManager.getInstance().setAcceptFileSchemeCookies(true);
      }

      // enable third party cookies
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
      }
   }
}