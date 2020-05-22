public static void main(String[] args) {
    List<A> aList = Collections.singletonList(new A());
    List<B> bList = Collections.singletonList(new B());
    A a = f(aList);
    A b = f(bList); // doesn't compile
    A c = g(bList);
    A d = g(bList);
}

public static <T extends Comparable<? super T>> T f(List<? extends T> list) {
    return null;
}

public static <T extends Comparable<? super T>> T g(List<? extends Comparable<? super T>> list) {
    return null;
}

final class A implements Comparable<A> {
    @Override
    public int compareTo(A o) {
        return 0;
    }
}
final class B implements Comparable<A> {
    @Override
    public int compareTo(A o) {
        return 0;
    }
}