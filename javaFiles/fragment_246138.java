public class TestVM {

    String value = "Default";

    public String getValue () {
        return value;
    }

    @Command
    @NotifyChange("value")
    public void changeValue () {
        value = "new value";
    }
}