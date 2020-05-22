public static void main(final String[] args) {
    try {
        throw new IllegalArgumentException("Illegal Argument 1!");
    } catch (final RuntimeException ex1) {
        try {
            throw new IllegalStateException("Illegal State 2!");
        } catch (final RuntimeException ex2) {
            ex2.addSuppressed(ex1);
            throw ex2;
        }
    }
}