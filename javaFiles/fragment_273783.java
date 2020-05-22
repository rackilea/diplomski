public class HtmlOption {
    private final String rawText;
    private final String htmlText;

    private HtmlOption(String rawText, String htmlText) {
        this.rawText = rawText;
        this.htmlText = htmlText;
    }

    public String toString() {
        return this.rawText;
    }

    // getters, equals and hashCode omitted
}