public class MyWebViewClient extends WebViewClient {

@Override
public boolean shouldOverrideUrlLoading(WebView view, String url) {
if(url == null){
return false;
}else if (url.trim().toLowerCase().endsWith(".img")) {//use whatever 
image formats you are looking for here.
 String imageUrl = url;//here is your image url, do what you want with 
 it
 Intent intent = new Intent(this, NewActivity.class);
//pass from here the data to next activity and load there
intent.putExtra("yourURL", imageUrl);

startActivity(intent)

}else{
view.loadUrl(url);
 }
}
}