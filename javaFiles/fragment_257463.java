public class GCD {
    public static void main(String[] args) {
        int result = generalizedGCD(new int[]{2, 4, 6, 8, 10});
        System.out.println(result);
    }

    public static int generalizedGCD(int[] arr) {
        int i = 1;
        int result = arr[0];

        while (i < arr.length) {
            if (arr[i] % result == 0) {
                i++;
            } else {
                result = arr[i] % result;
                i++;
            }
        }

        return result;
    }
}