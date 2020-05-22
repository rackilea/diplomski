@Override
protected void onPause() {
    super.onPause();
    SharedPreferences prefs = context.getApplicationContext().
            getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
    Editor edit = prefs.edit();
    edit.put("lastUrl",webView.getUrl());
    edit.commit();   // can use edit.apply() but in this case commit is better
}