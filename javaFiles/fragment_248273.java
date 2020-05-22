public class HealthDoublingEnchantment implements StatProvider {
    private final StatProvider delegate;

    public HealthDoublingEnchantment(StatProvider delegate) {
        this.delegate = delegate;
    }

    @Override
    public int health() {
        return delegate.health() * 2;
    }

    @Override
    public int intellect() {
        return delegate.intellect();
    }
}