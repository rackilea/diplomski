public interface IFeatureExtractionProvider
{
    public IFeatureExtraction build(IPreprocessing poPreprocessing);
}

private final static Map<Integer, IFeatureExtractionProvider> map;

static
{
    map = new HashMap<Integer, IFeatureExtractionProvider>();
    map.put(MARF.LPC, new IFeatureExtractionProvider() {

        @Override
        public IFeatureExtraction build(IPreprocessing poPreprocessing) {
            return new LPC(poPreprocessing);
        }
    });

    // and so on...
}

public static final IFeatureExtraction create(final int piFeatureExtractionMethod, IPreprocessing poPreprocessing)
        throws FeatureExtractionException
{
    IFeatureExtractionProvider provider = map.get(piFeatureExtractionMethod);

    if (provider == null)
        throw new RuntimeException("no provider for " + piFeatureExtractionMethod);

    return provider.build(poPreprocessing);
}