class YieldSubstitute<Data> {
    private int    n;
    private Data[] data;

    public YieldSubstitute(Data[] data) {
        this.n    = 0;
        this.data = data;
    }

    public Data getNext() {
        Data toReturn = data[n];
        n = (n + 1) % data.length;
        return toReturn;
    }
}