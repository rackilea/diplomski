public class MultiplierProviderImpl extends MultiplierProviderPOA {

    private final Multiplier multiplier;

    public MultiplierProviderImpl(Multiplier multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public Multiplier getMultiplier() {
        return multiplier;
    }
}