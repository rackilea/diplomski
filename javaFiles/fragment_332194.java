public class Total {
    private int totalA = 0;
    private int totalB = 0;

    public void addA(int a) {
        totalA += a;
    }

    public void addB(int b) {
        totalB += b;
    }

    public int getTotalA() {
        return totalA;
    }

    public int getTotalB() {
        return totalB;
    }
}