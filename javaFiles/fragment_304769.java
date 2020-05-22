public enum Constants {
    AUTHOR("bossman"),
    COMPANY("Bluegrass");

    private final String text;

    private Constants(String text) {
        this.text = text;
    }
    public String getText() {
        return this.text;
    }
}