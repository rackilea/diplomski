public class Test {
    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1, 2, 3, 4, 5};
        prints(ints);
    }

    static void prints(Object... ints) {
        for(Object i : ints) {
            System.out.println(i);
        }
    }
}