class MyJavaScriptInterface {
    @JavascriptInterface
    @SuppressWarnings("unused")
    public void processHTML(final String html) {
        myWebView.post(new Thread() {
            @Override public void run() {
                TextView text = findViewById(R.id.textView);



                sharedPreferences = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                if(!sharedPreferences.contains("statusKey")){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("statusKey", html);
                    editor.apply();
                    text.setText(html);
                }
                else {
                    text.setText(sharedPreferences.getString("statusKey", ""));
                }

            }
       });
    }
}