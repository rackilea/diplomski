public void startWeb(String url) {
    Intent intent = new Intent(activity.getBaseContext(),
            WebViewActivity.class);
    intent.setData(Uri.parse(url));
    this.activity.startActivity(intent);
}