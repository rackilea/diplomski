public class Substring {

    public static void main(String[] args) {
        String str = "1010011010";

        int k = 2;
        int i = 3;

        printAllSubstrings(str, i, k);

    }

    private static void printAllSubstrings(String str, int substringLength, int numberOfOnes) {
        // start index of the current window
        int startIndex = 0;

        // count of 1s in current window
        int count = 0;

        // count 1s in the first i characters
        for (int a = 0; a < substringLength; a++) {
            if (str.charAt(a) == '1') {
                count++;
            }
        }

        while (startIndex < str.length() - substringLength + 1) {
            if (count == numberOfOnes) {
                System.out.print(str.substring(startIndex, startIndex + substringLength));
                System.out.print(" ");
            }
            // Test next bit, which will be inside the window next iteration
            if (str.length() > startIndex + substringLength && str.charAt(startIndex + substringLength) == '1') {
                count ++;
            }
            // Test the starting bit, which will be outside the window next iteration
            if (str.charAt(startIndex) == '1') {
                count --;
            }
            startIndex++;
        }   
    }
}