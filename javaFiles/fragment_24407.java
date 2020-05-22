class X {
    private static final Factory FACTORY = ...;
    ...
    public interface Factory {
    }
}
// notice how both `X.Factory` and `X.FACTORY` become `X.factory` which is not allowed.