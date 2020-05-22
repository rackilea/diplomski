String url = "http://www.dw.com/ur/مارشل-لاء-کا-مطالبہ-سازش-یا-خواہش؟/a-19395440?maca=urd-rss-urd-all-1497-xml-mrss";
url = StringUtils.replaceEach(URLEncoder.encode(url, "UTF-8"), new String[]{"+", "*", "%7E"}, new String[]{"%20", "%2A", "~"})
HttpClient httpClient = HttpClientBuilder.create().build();
HttpGet httpget = new HttpGet(url);
HttpResponse response = httpClient.execute(httpget);
BasicResponseHandler bh = new BasicResponseHandler();
String res = new String(bh.handleResponse(response));
Document doc = Jsoup.parse(res);