class Element implements Comparable<Element> {

    private int data;
    int innerIndex, outerIndex;

    public Element(int data, int innerIndex, int outerIndex) {
        this.data = data;
        this.innerIndex = innerIndex;
        this.outerIndex = outerIndex;
    }

    public int getData() {
        return data;
    }

    public List<Integer> getIndicies() {
        return Arrays.asList(outerIndex+1, innerIndex+1);
    }

    @Override
    public int compareTo(Element o) {
        // negate to sort descending
        return -1*Integer.compare(this.data, o.data);
    }
}