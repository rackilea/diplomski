public int doSomethingElse(final String str) {
    try {
        return Integer.parseInt(str);
    }
    catch (final NumberFormatException e) {
        throw doThrow();
    }
}