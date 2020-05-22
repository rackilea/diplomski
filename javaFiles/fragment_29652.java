@Override
protected void onResume() {
    super.onResume();
    if(webView != null) {
        SharedPreferences prefs = context.getApplicationContext().
            getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
        String s = prefs.getString("lastUrl","");
        if(!s.equals("")) {
             webView.loadUrl(s);
        }
    }
}