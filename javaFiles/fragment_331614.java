static class XX {
    private static int p = 10; //p is only accessible to TT

    static class TT {
        static public int getT() {
            return p;
        }
    }

}