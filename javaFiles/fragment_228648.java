public class Demo {

    static class Exception1 extends Exception{}

    public static void main(String[] args) throws Exception1 {
        try {
            throw new Exception1();
        }
        catch(Exception ex) {
            throw ex;
        }
    }

}