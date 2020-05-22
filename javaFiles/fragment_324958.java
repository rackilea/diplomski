List<MemoryPoolMXBean> memoryPoolMXBeans = 
                                       ManagementFactory.getMemoryPoolMXBeans();
for (MemoryPoolMXBean pool: memoryPoolMXBeans) {
    out.println("pool: " + pool.getName());
    out.println("    type: " + pool.getType());
    out.println("    usage: " + pool.getUsage());
    out.println();
}