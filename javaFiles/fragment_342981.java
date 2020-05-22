private enum Randomization {
    USE_EXAMPLE_1(true, true),
    USE_EXAMPLE_2(true, true),
    KEEP_EXAMPLE_SIZE_1(false, true),
    RANDOM_1(false, false),
    RANDOM_2(false, false),
    RANDOM_3(false, false),
    ;

    final boolean keepAll;
    final boolean keepSize;

    private Randomization(boolean keepAll, boolean keepSize) {
        this.keepAll = keepAll;
        this.keepSize = keepSize;
    }
}