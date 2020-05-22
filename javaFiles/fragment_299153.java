public class Heap {
    final boolean isMinHeap;
    public Heap() {
        isMinHeap = true;
    }
    @Override
    public String toString() {
        if (isMinHeap) return "Min!";
        return "Not Min";
    }
}