public class Test {
    private String value;

    public String getValue() {
        return value;
    }

    public Test() {
        value = "default";
    }
    public Test(Test t) {
        this.value = t.getValue();
    }

    public Test(String value) {
        this.value = value;
    }

    public static void main(String[] argv) {
        Test t1 = new Test();
        Test t2 = new Test(t1);

        if (t1 == t2) {
            System.out.println("t1 == t2. should not happen");
        } else {
            System.out.println("t1 is a different instance from t2");
        }

        String s1 = "test";
        String s2 = "test";

        if (s1 == s2) {
            System.out.println("s1 == s2. strings initialized with quotes don't always get a new instance.");
        } else {
            System.out.println("s1 is a different instance from s2. should not happen");
        }

        String s3 = new String("test");
        String s4 = new String(s3);

        if (s3 == s4) {
            System.out.println("s3 == s4. should not happen.");
        } else {
            System.out.println("s3 is a different instance from s4, as they were newed.");
        }

    }
}