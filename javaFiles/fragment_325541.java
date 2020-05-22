for (int retries = 0; retries < 3; ++retries) {
    try {
        URL url = new URL("some_url");
        Document doc = Jsoup.parse(url, 9000);
        for (Map.Entry<String, String> entry : mappings.entrySet()) {
            calculateDiskFree(doc, entry.getValue(), entry.getKey());
        }
        break;
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}