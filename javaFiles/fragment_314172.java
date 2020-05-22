public static class Data {
    private final int first;
    private final String second;
    private final double third;

    public Data(int first, String second, double third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public int getFirst() {  return first; }
    public String getSecond() { return second; }
    public double getThird() {  return third; }

    @Override
    public String toString() {
        return first + "|" + second + "|" + third;
    }
}