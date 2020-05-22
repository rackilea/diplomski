public class WebAppInterface {
      MainActivity mainActivity;

      WebAppInterface(MainActivity mainActivity) {
          this.mainActivity= mainActivity;
      }

      @JavascriptInterface
      public void ad() {
          mainActivity.displayAd();
      }
  }