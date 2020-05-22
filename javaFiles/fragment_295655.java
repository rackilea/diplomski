interface ArrayPrinter {
    void printArray();
}

interface UnionFind extends ArrayPrinter {
    boolean isConnected(int p, int q);
    void makeUnion(int p, int q);
}

class DefaultPrinter implements ArrayPrinter {
    @Override
    public void printArray() {
        /**
         * do actual print
         */
    }
}

class QuickFind implements UnionFind {
    private final ArrayPrinter printDelegate = new DefaultPrinter();

    @Override
    public void printArray() {
        printDelegate.printArray();
    }

    /**
     * the rest
     */
}