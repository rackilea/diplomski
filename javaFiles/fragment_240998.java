private static List<Company> getCompanies(final CompanyFilter companyFilter) throws IOException {

    List<Company> companies = new ArrayList<>();

    URLConnection urlConn = new URL("https://angel.co/companies/startups?" + companyFilter.buildRequest()).openConnection();
    urlConn.setRequestProperty("User-Agent", "Mozilla");
    urlConn.connect();
    BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));
    HtmlContainer htmlObj = new Gson().fromJson(reader, HtmlContainer.class);

    Element doc = Jsoup.parse(htmlObj.getHtml());
    Elements data = doc.select("div[data-_tn]");

    if (data.size() > 0) {
        for (int i = 2; i < data.size(); i++) {
            companies.add(new Company(data.get(i).select("a").first().attr("title"),
                    data.get(i).select("a").first().attr("href"),
                    data.get(i).select("div.pitch").first().text()));
        }

    } else {
        System.out.println("no data");
    }
    return companies;
}