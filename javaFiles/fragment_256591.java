import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;


    for (GarbageCollectorMXBean gcBean : ManagementFactory.getGarbageCollectorMXBeans()) {
        System.out.println(gcBean.getCollectionCount());

        com.sun.management.GarbageCollectorMXBean sunGcBean = (com.sun.management.GarbageCollectorMXBean) gcBean;
        System.out.println(sunGcBean.getLastGcInfo().getStartTime());
    }