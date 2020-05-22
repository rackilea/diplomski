public class TestBlk {

    static {
        System.out.println("static block");
    }

    public TestBlk() {
        // Call constructor of java.lang.Object.
        super();

        // From instance (and field)initialiser.
        System.out.println("TEst block");

        // Rest of constructor:
    }


    public static void main(String args[]){
        TestBlk blk = new TestBlk();
        System.out.println("main block");
    }
}