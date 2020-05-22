public class UrlProbe {
    final String url;
    final String param2;
    public UrlProbe(String url) {
        this(url, this::debuggingStringTransform);
    }

    public UrlProbe(String url, Function<String, String> transform) {
        this(url, transform.apply("")); // <-- What should happen when url is referenced here?

    }
    public UrlProbe(String url, String param2) {
        this.url = url;
        this.param2 = param2;
    }

    private String debuggingStringTransform(String response) {
        System.out.println("Debugging new value from url " + url + ": " + response);
        return response;
    }
}