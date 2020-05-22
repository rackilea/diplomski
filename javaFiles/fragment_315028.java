public class Clazz<T> {
    T[] t = (T[]) new Object[5];

    public Clazz<T> methodA(int... ints) {
        Clazz<Integer> ints2 = new Clazz<Integer>();
        int l1 = t.length;
        int l2 = ints2.t.length;
        int remInd[] = new int[l1 - l2];
        return this;
    }

    public static void main(String...args) {
        Clazz<String> clazz = new Clazz<String>();
        clazz.methodA(54, 7);
    }
}