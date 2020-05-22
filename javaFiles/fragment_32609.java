URL feedUrl = new URL(feed)
HttpURLConnection httpcon = (HttpURLConnection)feedUrl.openConnection();
String encoding = new sun.misc.BASE64Encoder().encode("username:password".getBytes());
httpcon.setRequestProperty  ("Authorization", "Basic " + encoding);
SyndFeedInput input = new SyndFeedInput();
SyndFeed feed = input.build(new XmlReader(httpcon));