public class Main {

    public static void main(String[] args) {
        System.out.println(max(new int[]{6, 3, 9, 4}));
    }

    public static int max(int[] ints) {
        return max(ints, Integer.MIN_VALUE);
    }

    public static int max(int[] ints, int max) {
        if (ints.length == 0) {
            return max;
        } else {
            return max(Arrays.copyOfRange(ints, 1, ints.length), ints[0] > max ? ints[0] : max);
        }
    }

}