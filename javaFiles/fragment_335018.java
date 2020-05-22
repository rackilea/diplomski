Document doc = Jsoup.connect("http://www.tukui.org/dl.php").get();
Elements links = doc.select("a[href$=zip]");

List<String> list = new ArrayList<>();
for (Element link : links) {
    System.out.println("link : " + link.attr("href"));
    list.add(link.attr("href"));
}

String[] arr = list.toArray(new String[list.size()]);

System.out.println("array content:" + Arrays.toString(arr));