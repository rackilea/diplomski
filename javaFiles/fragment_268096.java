new MockUp<A> () {

    private int n;

    @Mock
    public void $init(Invocation inv, int n) {
        this.n = n;
        inv.proceed();
    }

    @Mock
    public boolean isCorrect(Invocation inv) {
        if (n == 3) {
            return true;
        }
        return inv.proceed();
    }
};