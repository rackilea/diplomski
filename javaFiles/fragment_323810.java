public class CountVowel implements Callable<Integer> {
    private final String input;

    public CountVowel(String input) {
        this.input = input;
    }

    public Integer call() {
        int vowels = 0;
        // Iterate over all the characters of the input String
        for (int j = 0; j < input.length(); j++) {
            // Lower case the current character as we need to ignore the case
            char ch = Character.toLowerCase(input.charAt(j));
            // Use a switch statement instead of an if as it is easier to read and faster
            switch (ch) {
                case 'a':
                case 'e':
                case 'o':
                case 'i':
                case 'u':
                    vowels++;
                    break;
            }
        }
        // Returns the sub total
        return vowels;
    }
}