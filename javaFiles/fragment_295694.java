public class CheckDict {
    static Set<String> dict = new HashSet<String>(Arrays.asList(new String[] 
                              {"Hi", "Hello", "Welcome", "To", "Stack", "Overflow"}));

    public static void main(String[] args) {
        System.out.println("Test 1: " + findDict("WelcomeToStackOverflow"));
        System.out.println("Test 2: " + findDict("StackOverflowWelcomeYou"));
    }

    static String findDict(String str) {
        // split the string when we encounter an upper case letter except at start
        String[] arr = str.split("(?<!^)(?=[A-Z])");
        StringBuilder output = new StringBuilder(arr[0]);
        for (int i=1; i< arr.length; i++) {
            if (!dict.contains(arr[i]))
                return null;
            else
                output.append(' ').append(arr[i]);
        }
        return output.toString();
    }
}