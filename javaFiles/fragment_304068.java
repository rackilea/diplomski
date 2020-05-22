public final class SimpleUser implements User {
    private final String cardId;
    public SimpleUser(final String cardId) {
        this.cardId = cardId;
    }
    @Override
    public void borrowItem(final String item) {
        // Borrowing logic.
    }
    @Override
    public String cardId() {
        return cardId;
    }
}