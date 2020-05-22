public class Sample {
    public static void main(String[] args) {
    //the words in dictionary
        String[] words = {"words", "sword", "nord", "chord", "score", "cores", "mors", "xyz", "scores", "ordsw"};
        String[] input = {"sword", "score", "tores", "nores"};
        for (String i : input) {
            List<String> found = findRearranged(i, words);
            System.out.println("For '" + i + "' found: " + Arrays.toString(found.toArray()));
        }
    }

    public static List<String> findRearranged(String input, String[] words) {
        List<String> found = new ArrayList<>();
        for (String w : words) {
            if (hasSameLetters(w, input)) {
                found.add(w);
            }
        }
        return found;
    }

    public static boolean hasSameLetters(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        while (a.length() > 0) {
            for (char c : b.toCharArray()) {
                int index = a.indexOf(c);
                if (index >= 0) {
                    a = a.replace(String.valueOf(c), "");
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}