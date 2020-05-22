wv.loadData("<a href=\"http://www.example.com/#_ftn0\">[0]</a>", "text/html", "UTF-8");

wv.setWebViewClient(new MyWebViewClient());

public class MyWebViewClient extends WebViewClient {
   @Override
   public boolean shouldOverrideUrlLoading(WebView view, String url) {
      Toast.makeText(getApplicationContext(), url, Toast.LENGTH_LONG).show();
      if(url.equal(urlyouclicked)){//here you compare the url you click 
          Toast.makeText(getApplicationContext(), OnClickedUrl, Toast.LENGTH_LONG).show();
      }
      return true;
   }
}