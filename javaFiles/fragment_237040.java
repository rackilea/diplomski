List<String> tags = new ArrayList<String>();
Document doc = Jsoup.connect("http://daniweb.com/").get();
Elements taglinks = doc.select("a.tagcloudlink");
for (Element link : taglinks) {
    tags.add(link.text());
}