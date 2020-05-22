class C {
    public final static boolean assertions = false;

    public static void main(String[] args) {
        if(assertions) {
            assert(System.nanoTime()==0);
        }
    }
}