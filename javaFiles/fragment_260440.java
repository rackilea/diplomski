public class HackerRank {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int numberOfWordsInMagazine = in.nextInt();
        final int numberOfWordsInNote = in.nextInt();

        final Map<String, Integer> wordsInMagazine = new HashMap<>();
        for (int i = 0; i < numberOfWordsInMagazine; i++) {
            final String word = in.next();
            wordsInMagazine.merge(word, 1, Integer::sum);
        }


        boolean canPrintMessage = true;
        for (int i = 0; i < numberOfWordsInNote; i++) {
            final String word = in.next();

            Integer remainingCount = wordsInMagazine.computeIfPresent(word, (key, value) -> value - 1);
            if (null == remainingCount || remainingCount < 0) {
                canPrintMessage = false;
                break;
            }
        }

        System.out.println(canPrintMessage ? "Yes" : "No");
    }
}