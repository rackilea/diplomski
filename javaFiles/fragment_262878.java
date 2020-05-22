public enum ParseResource {
    PUSH(Constants.API_URL);

    private static class Constants {
        private static final String API_URL = "https://api.parse.com/1";
    }

    private String url;
    private ParseResource(String url) { this.url = url; }
}