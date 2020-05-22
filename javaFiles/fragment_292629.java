public abstract class WeightedItem
{
    protected static final MessageBundle BUNDLE;

    static {
        // The day when you get serious, replace with a properties bundle
        final MessageSource source = MapMessageSource.newBuilder()
            .put(Cheese.class.getCanonicalName(), "cheese is overweight")
            .put(Baggage.class.getCanonicalName(), "baggage is %d kilos overweight")
            .build();

        BUNDLE = MessageBundle.newBuilder().appendSource(source).freeze();
    }

    protected int weight;

    protected final WeightException doException(final Object... params)
    {
        return new WeightException(BUNDLE.printf(getClass().getCanonicalName(),
            params));
    }
}