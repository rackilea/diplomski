public class ourViewClient extends WebViewClient {

Context context;


public ourViewClient (Context c){
    this.context = c;
}


@Override
public boolean shouldOverrideUrlLoading(WebView view, String url) {
    try{
        System.out.println("url called:::" + url);
        if (url.startsWith("tel:")) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
            context.startActivity(intent);
        }  else if (url.startsWith("http:")
                || url.startsWith("https:")) {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(intent);

        }  else if (url.startsWith("mailto:")) {

            MailTo mt=MailTo.parse(url);

            send_email(mt.getTo());

        }
        else {
            return false;
        }
    }catch(Exception e){
        e.printStackTrace();
    }


    return true;
}