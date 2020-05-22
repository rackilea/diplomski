public class Main {
    int i = 0;
    public static void main(String[] args) throws Exception {
        if (i == 0) throw new MyException("i must not be 0"); //Here it says about enclosing class
    }

    static class MyException extends Exception {
        public MyException(String e) {
            super(e);
        }
    }
}