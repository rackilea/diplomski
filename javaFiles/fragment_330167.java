public class BlackjackCardRandomizer implements Randomizer<BlackjackCard> {
    private static final Random RANDOM = new Random();

    @Override
    public BlackjackCard randomizeCard(List<BlackjackCard> deck) {
        Integer randIndex = RANDOM.nextInt(deck.size());
        return (Card) deck.get(randIndex);
    }
}