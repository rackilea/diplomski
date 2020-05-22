public class count {
    private static int countPositive(int[] elems) {
        int positive = 0;
        for (int i = 0; i < elems.length; i++) {
            if (elems[i] > 0) {
                positive++;
            }
        }
        return positive;
    }

    public static void main(String[] args) {

        int[] intArr = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            intArr[i] = Integer.parseInt(args[i]);
        }
        System.out.println(countPositive(intArr));
    }
}