class Q26 {
    public static Q26 q26;
    private static final int var1;
    private static int var2;

    static {
        var1 = 5;
        q26 = new Q26();
        var2 = 7;
    }

    public int ans;

    public Q26() {
        ans = var1 + var2;
    }
}