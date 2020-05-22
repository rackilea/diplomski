public class MySubclass1 extends MyAbstractClass {
    @Transient
    private final String type = "TYPE_1";

    public String getType() {
        return type;
    }
}