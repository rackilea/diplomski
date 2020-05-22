String requestURL = "https://finance.yahoo.com/quote/AAPL/financials?p=AAPL";
String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36 OPR/56.0.3051.43";
String row = "totalRevenue";

try {
    Document doc = Jsoup.connect(requestURL).userAgent(userAgent).get();
    String html = doc.html();
    //Log.d("html", html);

    Elements scriptTags = doc.getElementsByTag("script");
    String re = "root\\.App\\.main\\s*\\=\\s*(.*?);\\s*\\}\\(this\\)\\)\\s*;";

    for (Element script : scriptTags) {
        Pattern pattern = Pattern.compile(re, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(script.html());

        if (matcher.find()) {
            String data = matcher.group(1);
            //Log.d("data", data);

            JSONObject jo = new JSONObject(data);
            JSONArray table = getTable(jo);
            //Log.d("table", table.toString());

            String[] tableRow = getRow(table, row);
            String values = TextUtils.join(", ", tableRow);
            Log.d("values", values);
        }
    }
} catch (Exception e) {
    Log.e("err", "err", e);
}