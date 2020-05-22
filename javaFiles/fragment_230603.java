public class MySimilarity extends DefaultSimilarity {
    @Override
    public float lengthNorm(FieldInvertState state) {
        return state.getBoost() * ((float) (1.0 / Math.sqrt(state.getOffset())));
    }
}