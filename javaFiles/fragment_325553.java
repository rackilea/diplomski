public enum Properties
{
    NAME("name", true),
    CATEGORY("category", false);

    private final String s;
    private final boolean b;

    private Properties(String s, boolean b) {
        this.s = s;
        this.b = b;
    }

    public String getS() {
        return s;
    }

    public boolean getB() {
        return b;
    }
}