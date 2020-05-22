public class Solution {
    public long largestPalindrome(int n) {
        if( n==0 ) return 1;

        int[] arr = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
        long max_palindrome = 0;
        for (long x = arr[n] - 1; x >= arr[n - 1]; x--) {
            for (long y = x; y >= arr[n - 1]; y--) {
                long maybe = x * y;
                if (maybe <= max_palindrome) {
                    break;
                }

                if (is_Palindrome(maybe)) {
                    max_palindrome = maybe;
                    System.out.printf("Palindrome: %dx: %d, y: %d%n", max_palindrome, x, y);
                }
            }
        }
        return max_palindrome % 1337;
    }

    public boolean is_Palindrome(long toCheck) {
        String cand = String.valueOf(toCheck);
        final int len = cand.length() - 1;
        final int maxIdx = len >> 1;
        for (int i = 0; i <= maxIdx; i++) {
            if (cand.charAt(i) != cand.charAt(len - i))
                return false;
        }
        return true;
    }
}