public interface MyInterface
{
    public String string();
    public int integer();
    public static MyInterface of(String s, int i) {
        return new MyInterface() {
            @Override public String string() { return s; }
            @Override public int integer() { return i; }
        };
    }
}