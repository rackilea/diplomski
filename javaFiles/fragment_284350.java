import java.lang.management.GarbageCollectorMXBean
import java.lang.management.ManagementFactory
import java.lang.management.MemoryPoolMXBean
import java.lang.management.MemoryUsage

log("Heap", ManagementFactory.getMemoryMXBean().getHeapMemoryUsage());
log("NonHeap", ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage());
List<MemoryPoolMXBean> beans = ManagementFactory.getMemoryPoolMXBeans();
for (MemoryPoolMXBean bean: beans) {
    log(bean.getName(), bean.getUsage());
}

for (GarbageCollectorMXBean bean: ManagementFactory.getGarbageCollectorMXBeans()) {
    log(bean.getName(), bean.getCollectionCount(), bean.getCollectionTime());
}