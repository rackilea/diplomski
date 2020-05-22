public abstract class RandomVariable<Sample> {
    private final Map<Sample, Integer> sampleSpace;

    public RandomVariable() {
        Map<Sample, Integer> map = new HashMap<>();
        populateSampleSpace(map);
        this.sampleSpace = Collections.unmodifiableMap(map);
    }

    protected abstract void populateSampleSpace(Map<Sample, Integer> sampleSpace);
}