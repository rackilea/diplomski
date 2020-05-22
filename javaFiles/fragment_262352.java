public class TestClass {
    public static void main(String[] args) {
        method(2);//Notification here!
    }
    static void method(int a) throws myException {
    }
}
class myException extends Exception {

}