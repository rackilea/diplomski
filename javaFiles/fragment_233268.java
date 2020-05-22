public class Test {
    public static void main(String[] args) {
        CustomClass cc = new CustomClass();
        if (cc != returnNull())
            cc.errlog( returnNull() );
    }
    public static <T> T returnNull() {
        return (T) null;
    }
}
class CustomClass {
    void errlog(Exception e) {
    }
}