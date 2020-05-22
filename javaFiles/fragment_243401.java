class Q26 {
    // Declared first, but NOT first to be initialized...
    public static Q26 q26 = new Q26();
    public int ans;
    // The honor befalls to this one, since it is declared `final`
    private static final int var1 = 5;
    private static int var2 = 7; // zero until initialized

    public Q26() {
        ans = var1 + var2;
    }
}