public class VarArgSample {

    static int sum(int i, int... marks) {
        int total = 0;
        for (int mark : marks) {
            total = total + mark;
        }
        return total;
    }

    public static void main(String[] args) {

        // invoking with variable arguments
        System.out.println(sum(1, 2, 3));

        // same invocation using an array
        int arr[] = { 2, 3 };
        System.out.println(sum(1, arr));
    }
}