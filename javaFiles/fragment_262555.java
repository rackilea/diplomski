public class MemoryStat {

    public final long heapBytes;

    public final long directBytes;

    public MemoryStat(ByteBufAllocator byteBufAllocator) {
        long directMemory = 0;
        long heapMemory = 0;

        if (byteBufAllocator instanceof ByteBufAllocatorMetricProvider) {
            ByteBufAllocatorMetric metric = ((ByteBufAllocatorMetricProvider) byteBufAllocator).metric();
            directMemory = metric.usedDirectMemory();
            heapMemory = metric.usedHeapMemory();
        }

        this.directBytes = directMemory;
        this.heapBytes = heapMemory;
    }
}