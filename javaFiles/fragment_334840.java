class Test {
    private int val;

    public Test(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
public class TestSame {
    public static void main(String[] args) {
        Test t1 = new Test(10);
        Test t2=t1;
        System.out.println(t1.getVal());
        System.out.println(t2.getVal());

        t1.setVal(20);

        System.out.println(t1.getVal());
        System.out.println(t2.getVal());

    }
}