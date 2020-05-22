public class ThrowTest {

    public static final void main(String[] args) {
        ThrowTest tt;

        tt = new ThrowTest();
        try {
            tt.t1();                                   // Line 8
        }
        catch (Exception ex) {
            System.out.println("t1:");
            ex.printStackTrace(System.out);
        }
        try {
            tt.t2();                                   // Line 15
        }
        catch (Exception ex) {
            System.out.println("t2:");
            ex.printStackTrace(System.out);
        }
    }

    private static final Exception buildEx() {
        return new Exception("t1");                    // Line 24
    }

    private void t1() 
    throws Exception {
        throw buildEx();                               // Line 29
    }

    private void t2() 
    throws Exception {
        throw new Exception("t2");                     // Line 34
    }
}