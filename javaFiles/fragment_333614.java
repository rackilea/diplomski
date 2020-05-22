public class Test {

    public Test a;

    public Test getA() {
        return this.a;
    }

    public Test add(Test a) {
        this.a = a;
        return this;
    }

    public int foo(int a, int b, int c) {
        return a+b+c;
    }

    public long foovar(Long... ai) {
        long r = 0;
        for (long i:ai) r+= i;
        return r;
    }
}