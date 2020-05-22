public class Solution {

    public static void main(String[] args) {
        String str = "abc??cde???g?"; // Example
        char[] arr = str.toCharArray();
        int length = arr.length;

        // Init value for count, start and end
        int count = 0;
        char start = 'a';
        char end = 'a';
        for (int i = 0; i < length; i++) {
            if (arr[i] == '?') { // We found a question mark
                boolean foundEnd = false;
                int total = 1; // Currently the total of question mark is 1
                for (int j = i + 1; j < length; j++) { // Count the total question mark for our method and the end character
                    if (arr[j] != '?') { // Not question mark
                       end = arr[j]; // Update end;
                       i = j -1;
                       foundEnd = true;
                       break;
                    } else {
                        total++;
                    }
                }

                if (!foundEnd) { // Change end to start in the case our question mark continue to the end of string
                    end = start;
                }
                // Start to counting and reset end to 'z'
                int result = countPossibleCharacters(total, start, end);
                if (count > 0) {
                    count *= result;
                } else {
                    count += result;
                }
                end = 'z';
            } else {
                start = arr[i];
            }
        }

        System.out.println("The total is : " + count);
    }

    /**
     * Count the possible characters
     * @param total the total question mark
     * @param start the character in the left side of question mark
     * @param end the character in the right side of question mark
     * @return
     */
    static int countPossibleCharacters(int total, char start, char end) {
        if (total == 0) {
            return 0;
        }

        if (total == 1) {
            return end - start + 1;
        }

        if (total >= 2) {
            int count = 0;

            /**
             * We have a range of characters from start to end
             * and for each character we have 2 options: use or don't use it
             */
            // We use it, so the total of question mark will be decrement by 1
            count += countPossibleCharacters(total - 1, start, end);

            // We don't use it, so the range of characters will be decrement by 1
            if (start < end) {
                count += countPossibleCharacters(total, ++start, end);
            }

            return count;
        }

        return 0;
    }
}