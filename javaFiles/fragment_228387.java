public List<LastFmImage> getLastFmImages(String artistName, int limit, int page) throws IOException {
    String apiUrl = "http://ws.audioscrobbler.com/2.0/?method=artist.getimages&artist="
            + URLEncoder.encode(artistName)
            + "&api_key="
            + APIKEY
            + "&limit=" + limit + "&page=" + page;

    Document doc = Jsoup.connect(apiUrl).timeout(20000).get();
    Elements images = doc.select("images");

    ArrayList<LastFmImage> result = new ArrayList<LastFmImage>();
    final int nbrOfImages = images.size();
    for (int i = 0; i < nbrOfImages; i++) {
        Element image = images.get(i);
        String title = image.select("title").first().text();
        Elements sizes = image.select("sizes").select("size");
        final int nbrOfSizes = sizes.size();
        for (int j = 0; j < nbrOfSizes; j++) {
            Element size = sizes.get(i);

            result.add(new LastFmImage(title, size.text(),
                    size.attr("name"),
                    Integer.parseInt(size.attr("width")),
                    Integer.parseInt(size.attr("height"))));
        }
    }
    return result;
}