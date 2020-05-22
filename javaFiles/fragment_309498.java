public static int[] blackjackByIteration(int[] hands) {
    OptionalInt oi = Arrays.stream(hands).filter(i -> i <= 21).max();
    if (oi.isPresent()) {
        int value = oi.getAsInt();
        return IntStream.range(0, hands.length).filter(i -> hands[i] == value).toArray();
    }
    return new int[0];
}