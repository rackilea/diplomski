/**
 * Disables effect of lengthNorm
 */
public class CustomSimilarity extends ClassicSimilarity
{
    public float lengthNorm(FieldInvertState state) {
        return state.getBoost();
    }
}