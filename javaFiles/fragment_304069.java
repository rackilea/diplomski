public final class ExistingUser implements User {
    private final User origin;
    public ExistingUser(final User origin) {
        this.origin = origin;
    }
    @Override
    public void borrowItem(final String item) {
        if (!exists(cardId())) {
            throw new IllegalStateException("Unrecognized user!");
        }
        origin.borrowItem(item);
    }
    @Override
    public String cardId() {
        return origin.cardId();
    }
    private boolean exists(String cardId) {
        // Check if exists...
    }
}