private class MyJavaScriptInterface {
    @JavascriptInterface
    public void handleHtml(String html) {
         // Use jsoup on this String here to search for your content.
         Document doc = Jsoup.parse(html);

         // Now you can, for example, retrieve a div with id="username" here
         Element usernameDiv = doc.select("#username").first();
    }
}