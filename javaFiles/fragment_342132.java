public class Test {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4, 5};
        prints(ints);
    }

    static void prints(Object... ints) {
        for(Object i : ints) {
            System.out.println(i);
        }
    }
}