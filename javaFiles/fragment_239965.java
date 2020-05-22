public class Test {
    public static void main(String[] args) {
        String[] wordsFromFile = { "appear", "attack", "cellar", "copper",
                                   "erratic", "grotesque", "guitar", "guttural",
                                   "kittens", "mean", "suit", "trick" };
        List<byte[]> wordList = new ArrayList<>();
        for (String word : wordsFromFile) // Simulating read from file
            wordList.add(word.getBytes(StandardCharsets.US_ASCII));
        byte[][] symbolTable = wordList.toArray(new byte[wordList.size()][]);

        test(symbolTable, "abc");
        test(symbolTable, "attack");
        test(symbolTable, "car");
        test(symbolTable, "kittens");
        test(symbolTable, "xyz");
    }
    private static void test(byte[][] symbolTable, String word) {
        int idx = Arrays.binarySearch(symbolTable,
                                      word.getBytes(StandardCharsets.US_ASCII),
                                      Test::compare);
        if (idx < 0)
            System.out.println("Not found: " + word);
        else
            System.out.println("Found    : " + word);
    }
    private static int compare(byte[] w1, byte[] w2) {
        for (int i = 0, cmp; i < w1.length && i < w2.length; i++)
            if ((cmp = Byte.compare(w1[i], w2[i])) != 0)
                return cmp;
        return Integer.compare(w1.length, w2.length);
    }
}