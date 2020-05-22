public class MySimilarity extends TFIDFSimilarity {

    public MySimilarity() {}

    @Override
    public float coord(int overlap, int maxOverlap) {
        return overlap / (float)maxOverlap;
    }

    @Override
    public float queryNorm(float sumOfSquaredWeights) {
        return (float)(1.0 / Math.sqrt(sumOfSquaredWeights));
    }

    //Since length norms are generally going to leave us with results less than one, multiply
    //by a sufficiently large number to not lose all our precision when casting to long
    private static final float NORM_ADJUSTMENT = Integer.MAX_VALUE;

    @Override
    public final long encodeNormValue(float f) {
        return (long) (f * NORM_ADJUSTMENT);
    }

    @Override
    public final float decodeNormValue(long norm) {
        System.out.println(norm);
        return ((float) norm) / NORM_ADJUSTMENT;
    }

    @Override
    public float lengthNorm(FieldInvertState state) {
        return state.getBoost() * ((float) (1.0 / Math.sqrt(state.getOffset())));
    }

    @Override
    public float tf(float freq) {
        return (float)Math.sqrt(freq);
    }

    @Override
    public float sloppyFreq(int distance) {
        return 1.0f / (distance + 1);
    }

    @Override
    public float scorePayload(int doc, int start, int end, BytesRef payload) {
        return 1;
    }

    @Override
    public float idf(long docFreq, long numDocs) {
        return (float)(Math.log(numDocs/(double)(docFreq+1)) + 1.0);
    }

    @Override
    public String toString() {
        return "DefaultSimilarity";
    }
}