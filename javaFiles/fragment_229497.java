public abstract class Fudge {
    private static final Map<String, Fudge> FUDGE_TYPES = ImmutableMap.of(
        "Type1", new Type1Fudge(),
        "Type2", new Type2Fudge()
        // Add new entry when implemented
    );

    public static Fudge getFudge(final String fudge) {
        if (FUDGE_TYPES.containsKey(fudge)) {
            return FUDGE_TYPES.get(fudge);
        } else {
            // handle missing fudge depending on your preference
        }
    }
}