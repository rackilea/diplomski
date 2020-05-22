public enum ParseResource {
    PUSH(getApiUrl());

    private static String getApiUrl() { return "https://api.parse.com/1"; }

    private String url;
    private ParseResource(String url) { this.url = url; }
}