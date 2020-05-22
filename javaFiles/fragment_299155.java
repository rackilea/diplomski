public class Heap {
    final boolean isMinHeap = true;
    public Heap() {
    }
    @Override
    public String toString() {
        if (isMinHeap) return "Min!";
        return "Not Min";
    }
}