private static CompanyFilter getCompanyFilter(final String filter, final int page) throws IOException {

    String response = Jsoup.connect("https://angel.co/company_filters/search_data")
            .header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
            .header("X-Requested-With", "XMLHttpRequest")
            .data("filter_data[company_types][]=", filter)
            .data("sort", "signal")
            .data("page", String.valueOf(page))
            .userAgent("Mozilla")
            .ignoreContentType(true)
            .post().body().text();

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();
    return gson.fromJson(response, CompanyFilter.class);
}