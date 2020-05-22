public static void main(String[] args) {
    System.out.println(reverseOrderOfWords("hello world"));
}

public static String reverseOrderOfWords(String s) {
    StringBuilder sb = new StringBuilder();
    for (String word : s.split(" ")) {
        sb.insert(0, word + " ");
    }
    return sb.toString().trim();
}