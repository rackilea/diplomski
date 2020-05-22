public class SimpleGrowingString {
    private StringBuilder stringBuilder;

    public SimpleGrowingString() {
        this.stringBuilder = new Stringbuilder();
    }

    public void addToString(String str) {
        this.stringBuilder.append(str);
    }

    public String getString() {
        return this.stringBuilder.toString();
    }
}