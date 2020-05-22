public void printWikipediaResults() throws IOException {
    JsonNode tree = new ObjectMapper().readTree("<Wikipedia JSON>");

    // get number of results ( length of titles array )
    int totalResults = tree.get(1).size();
    // initialize a new ArrayList to store the WikiArticles into
    List<WikiArticle> results = new ArrayList<>(totalResults);
    // for each article, create a new object from the data contained in the arrays
    for (int i = 0; i < totalResults; i++) {
        results.add(new WikiArticle(
                tree.get(1).get(i).asText(),
                tree.get(2).get(i).asText(),
                tree.get(3).get(i).asText()
        ));
    }

    System.out.println("Showing results for: " + tree.get(0).asText());
    for (WikiArticle article : results) {
        System.out.println(article.title + ": " + article.url);
    }
}

public static class WikiArticle {
    public String title;
    public String desc;
    public String url;

    public WikiArticle(String title, String desc, String url) {
        this.title = title;
        this.desc = desc;
        this.url = url;
    }
}