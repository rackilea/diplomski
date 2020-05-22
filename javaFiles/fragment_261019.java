@Override
public String toString() {
    try {
        if (forceNoValues)
            return getQueryString();
        // 1) try first with all values inlined (will not work if some values require custom codecs,
        // or if the required codecs are registered in a different CodecRegistry instance than the default one)
        return maybeAddSemicolon(buildQueryString(null, CodecRegistry.DEFAULT_INSTANCE)).toString();
    } catch (RuntimeException e1) {
        // 2) try next with bind markers for all values to avoid usage of custom codecs
        try {
            return maybeAddSemicolon(buildQueryString(new ArrayList<Object>(), CodecRegistry.DEFAULT_INSTANCE)).toString();
        } catch (RuntimeException e2) {
            // Ugly but we have absolutely no context to get the registry from
            return String.format("built query (could not generate with default codec registry: %s)", e2.getMessage());
        }
    }
}