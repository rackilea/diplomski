class MyJavaScriptInterface {

    private Context ctx;
    MyJavaScriptInterface(Context ctx) {
        this.ctx = ctx;      
    }

    @JavascriptInterface
    public void showHTML(String html) {
        System.out.println(html);
    }

}