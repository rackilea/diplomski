public static void main(String[] args) {
    try {
        // add user agent
        Document doc = Jsoup.connect("https://www.nasdaq.com/symbol/aapl/financials?query=balance-sheet")
                .userAgent("Mozilla/5.0").get();
        Elements trs = doc.select("tr");
        for (Element tr : trs) {
            Elements tds = tr.select(".td_genTable");
            // avoid tr headers that produces NullPointerException
            if(tds.size() == 0) continue;
            // look for siblings (see the html structure of the web)
            Element td = tds.first().siblingElements().first();
            System.out.println(td.text());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}