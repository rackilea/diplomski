Class c = java.nio.Bits.class;
Field maxMemory = c.getDeclaredField("maxMemory");
maxMemory.setAccessible(true);
Field reservedMemory = c.getDeclaredField("reservedMemory");
reservedMemory.setAccessible(true);
synchronized (c) {
    Long maxMemoryValue = (Long)maxMemory.get(null);
    Long reservedMemoryValue = (Long)reservedMemory.get(null);
}