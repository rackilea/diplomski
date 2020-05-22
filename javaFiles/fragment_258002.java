public class ThrowTest {
    private static Exception e = new Exception("t1"); // Line 2

    public static final void main(String[] args) {
        ThrowTest tt;

        tt = new ThrowTest();
        try {
            tt.t1();
        }
        catch (Exception ex) {
            System.out.println("t1:");
            ex.printStackTrace(System.out);
        }
        try {
            tt.t2();                                  // Line 16
        }
        catch (Exception ex) {
            System.out.println("t2:");
            ex.printStackTrace(System.out);
        }
    }

    private void t1() 
    throws Exception {
        throw this.e;
    }

    private void t2() 
    throws Exception {
        throw new Exception("t2");                    // Line 31
    }
}