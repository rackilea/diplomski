public static void main(String[] args) {
    Runtime rt = Runtime.getRuntime();
    long prevTotal = 0;
    long prevFree = rt.freeMemory();

    for (int i = 0; i < 2_000_000; i++) {
        long total = rt.totalMemory();
        long free = rt.freeMemory();
        if (total != prevTotal || free != prevFree) {
            long used = total - free;
            long prevUsed = (prevTotal - prevFree);
            System.out.println(
                "#" + i +
                ", Total: " + total +
                ", Used: " + used +
                ", ∆Used: " + (used - prevUsed) +
                ", Free: " + free +
                ", ∆Free: " + (free - prevFree));
            prevTotal = total;
            prevFree = free;
        }
        map.put(i, new NewObject());
    }
}