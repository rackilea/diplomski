public static void main(String[] args) {
    int[] counts = countUniqueCharacters("SSDDVVDSSS");
    for (int i = 0; i < counts.length; i++) {
        if (counts[i] != 0) {
            System.out.println("char " + ((char) ('A' + i)) + " repeated " + counts[i] + " times");
        }
    }
}

    public static int[] countUniqueCharacters(String input) {
    int[] counts = new int[26];
    for (int i = 0; i < input.length(); i++) {
        counts[input.charAt(i) - 'A']++;
    }
    return counts;
}