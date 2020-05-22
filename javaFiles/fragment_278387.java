public class SubStringWithKUniqueCharacters {

    public static void main(String[] args){

        System.out.println(longestSubStringWithUniqueK("aabbcdeeeeggi", 3));
        System.out.println(longestSubStringWithUniqueK("aabbcdeeeeggi", 2));
    }

    public static String longestSubStringWithUniqueK(String input, int k){
        int len = input.length();
        Set<Character> unique = new HashSet<>();

        int i = 0;
        int j = 0;
        int count = 0;
        int maxStartIndex = 0;
        int maxEndIndex  = 0;
        int maxLen = 0;
        char[] inputArr = input.toCharArray();

        while (i<len){

            if (count==k && j -i > maxLen){
                maxStartIndex = i;
                maxEndIndex = j;
                maxLen = maxEndIndex - maxStartIndex;
            }
            // 1. if we reach the end of the string, we're done.
            if (j + 1 > len){
                break;
            }
            // 2. changed to count <= k here
            else if (count<= k && j<len){
                if (unique.add(inputArr[j])){
                    count++;
                }
                j++;
            }
            else {                          
                if (unique.remove(inputArr[i])){
                    // 3. remove all consecutive chars of the same value
                    char c = inputArr[i];  // save as temp char
                    while (inputArr[i] == c)
                    {
                        i++;
                    }
                    count--;                          
                }                
            }
        }
         return input.substring(maxStartIndex,maxEndIndex);
    }
}