String html = "<html><head></head><body><div style='padding-top:25px;' onclick='javascript.alert('hi');'>This is a sample div <span class='sampleclass'>This is a simple span</span></div></body></html>";

Whitelist wl = Whitelist.simpleText();
wl.addTags("div", "span"); // add additional tags here as necessary
String clean = Jsoup.clean(html, wl);
System.out.println(clean);