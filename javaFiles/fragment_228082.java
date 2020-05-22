class Test {
    public Test(final int a, final int b) {
        this.a = a;
        this.b = b;
    }

    public int a;
    public int b;
}

public class Main {

    public static void main(String[] args) throws Exception {
        List<Test> values = new ArrayList<Test>(2);
        values.add(new Test(1, 2));
        values.add(new Test(3, 4));

        List<Test> readOnly = Collections.unmodifiableList(values);
        for (Test t : readOnly) {
            t.a = 5;
        }

        for (Test t : values) {
            System.out.println(t.a);
        }
    }

}