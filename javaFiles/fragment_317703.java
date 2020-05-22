class Card {
    static Supplier<Integer> randomGenerator = () -> (int) (Math.random() * 13);

    static String[] supportedFs =
            new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    final CardValue value = new CardValue(determineFace());
    final Suite suit = determineSuit();

    static String determineFace() {
        return supportedFs[randomGenerator.get()];
    }

    static Suite determineSuit() {
        // TODO: to be finished according to your logic.
        return Suite.CLUBS;
    }
}