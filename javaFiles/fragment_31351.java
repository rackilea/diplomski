CookieManager cookies = new CookieManager();
cookies.getCookieStore().add(null, new HttpCookie("app.flickgo.com", "/"));
cookies.getCookieStore().add(null, new HttpCookie("has_js", "1"));
cookies.getCookieStore().add(null, new HttpCookie(session_name, session_id));

URL url = new URL("http://app.flickgo.com/apistuff/node.json");
HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
urlconnection.setRequestMethod("POST");
urlconnection.setDoOutput(true);
urlconnection.setRequestProperty("Content-Type", "application/json");

try(OutputStreamWriter writer = new OutputStreamWriter(urlconnection.getOutputStream())) {
    writer.write("{\"title\":\""+title+"\",\"type\":\"article\",\"body\":{\"und\":[{ \"value\":\""+body+"\"}]}}");
}

int rc = urlconnection.getResponseCode();