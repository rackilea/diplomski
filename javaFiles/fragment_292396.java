String myKeywords = "ice cream";
String myTimezone = "Etc/GMT+2";

String url = "https://www.google.com/trends/trendsReport?hl=en&q=" + URLEncoder.encode(keywords, "UTF-8") +"&tz="+URLEncoder.encode(myTimezone, "UTF-8")+"&content=1";

Document doc = Jsoup.connect(url).timeout(10000).get();
Element scriptElement = doc.select("div#TIMESERIES_GRAPH_0-time-chart + script").first();

if (scriptElement==null) {
   throw new RuntimeException("Unable to locate trends data.");
}

String jsCode = scriptElement.html(); 
// parse jsCode to extract charData...