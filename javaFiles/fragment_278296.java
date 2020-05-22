public class SubsequenceNotSubtring {
    static void subseqNotSubstring(String word, int L) {
        search(word, L, "", 0);
    }
    static void search(String word, int L, String subseq, int index) {
        if (L == 0 && !word.contains(subseq)) {
            System.out.println(subseq);
            return;
        }
        for (int i = index; i < word.length(); i++) {
            search(word, L-1, subseq + word.charAt(i), i+1);
        }
    }
    public static void main(String[] args) {
        subseqNotSubstring("apple", 3);
        subseqNotSubstring("aaabbab", 3);
    }
}