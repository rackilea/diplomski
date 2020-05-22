final String feedURLStr = "http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk#";
HttpClient client = new DefaultHttpClient();
HttpGet method = new HttpGet(feedURLStr);
ResponseHandler<String> handler = new BasicResponseHandler();
final String responseStr = client.execute(method, handler);
System.out.println(responseStr);