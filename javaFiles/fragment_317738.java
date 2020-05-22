class A<T extends Number> extends B<T> {
    public Number f(float j) {
        return 1f;
    }

    public Number f(T j) {
        return j;
    }
}


public class J {
    public static void main(String[] args) {
        A<Float> a = new A<>();
        Number r = a.f(2f);
        System.out.println(r);
    }
}