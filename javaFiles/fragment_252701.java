public class WordsInWords {
    public static void main(String[] args) throws IOException {
        String file = "C:\\Users\\masta\\IdeaProjects\\podstawka-spring-java\\words.txt";
        BufferedReader r = new BufferedReader(new FileReader(file));
        List<String> words = new ArrayList<>();
        String c = r.readLine();
        while (c != null) {
            words.add(c);
            c = r.readLine();
        }
        for (int i = 0; i < words.size(); i++) {
            System.out.println("Words: " + words.get(i));
        }
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        List<String> found = findRearranged(input, words);
        System.out.println("For '" + input + "' found: " + Arrays.toString(found.toArray()));
    }

    public static List<String> findRearranged(String input, List<String> words) {
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