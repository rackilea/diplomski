Document doc = Jsoup.connect(
        "http://www.10tv.com/content/sections/weather/closings.html")
        .get();
for (Element tr : doc.select("#closings tr")) {
    Element tds = tr.select("td").first();
    if (tds != null) {
        String county = tr.select("td:eq(0)").text();
        String schoolName = tr.select("td:eq(1)").text();
        String status = tr.select("td:eq(2)").text();
        System.out.println(String.format(
                "county: %s, schoolName: %s, status: %s", county,
                schoolName, status));
    }
}