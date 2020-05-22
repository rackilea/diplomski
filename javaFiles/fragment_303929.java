static String var="";

public void onCreate() {
webview.getSettings().setJavaScriptEnabled(true);
webview.addJavascriptInterface(this, "HTMLOUT");
bt1.setOnClickListener(new OnClickListener(){
    public void onClick(View v){        
        for(int i=0;i<5;i++){
    webview.loadUrl("javascript:window.HTMLOUT.processHTML(document.getElementsByName('name')["+i+"].src);");
        }
    }
);
}

@JavascriptInterface
 public static void processHTML(String html){    
    var=html;
    Log.i("CODE : ",var);
 }