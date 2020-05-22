public static void main(String args[]) {
    System.out.println(indexOfWord("One day I saw the beautiful bird", "the"));
}

private static int indexOfWord(String input, String word) {
    Scanner s = new Scanner(input);
    Pattern p = Pattern.compile("\\S*");
    int count = 0;
    while (s.hasNext(p)) {
        if (word.equals(s.next(p)))
            return count;
        count++;
    }
    return -1;
}