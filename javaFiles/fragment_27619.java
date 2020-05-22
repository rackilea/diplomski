WebView webView = new WebView();

jfxPanel.setScene(new Scene(webView));
webEngine = webView.getEngine();
webEngine.setJavaScriptEnabled(true);
webEngine.setConfirmHandler(new ModalConfirmDialog(self));


// get the window and pass the required daos
JSObject jsobj = (JSObject) webEngine.executeScript("window");
// pass the dataaccess to the js context
jsobj.setMember("javaapi", getApiInstance());

webEngine.load("http://whatever.tld/mypage.html");