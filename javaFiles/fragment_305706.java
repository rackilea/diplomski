final class ArraysDemo$Lambda$1 implements IntUnaryOperator {
    final int[] b;
    ArraysDemo$Lambda$1(int[] b) {
        this.b = b;
    }
    public int applyAsInt(int i) {
        return ArraysDemo.lambda$main$0(b, i);
    }
}