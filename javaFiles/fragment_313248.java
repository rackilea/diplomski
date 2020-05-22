public class WhiteBoxTest {
    private final String name;
    private WhiteBoxTest (String name) {
        this.name = name;
    }
    public String getName () {
        return this.name;
    }
}