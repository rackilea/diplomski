public static URL buildUrl(String token, String item) {
    String query = new StringBuilder()
            .append(PARAM_TOKEN).append("=").append(token).append("&")
            .append(PARAM_ITEM).toString();

    Uri builtUri = Uri.parse(BASE_URL).buildUpon()
            .encodedQuery(query)
            .build();

    URL url = null;
    try {
        url = new URL(builtUri.toString());
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }

    return url;
}