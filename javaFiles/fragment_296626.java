String imagePath = "file:///android_asset/menu.jpg";
String markup = "<html><head><style type='text/css'>img {width: 100%%;}</style></head><body style='margin: 0; padding: 0'><img src='%s' /></body></html>";
markup = String.format(markup, imagePath);
try {
  markup = URLEncoder.encode(markup,"utf-8");
} catch (UnsupportedEncodingException e) {
} 
markup = markup.replace('+',' ');
webView.loadData(markup, "text/html", "utf-8");