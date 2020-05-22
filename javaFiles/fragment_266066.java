System.gc();
for (int i = 0; i < 5; i++) {
    Throwable[] ts = new Throwable[10000];
    long free = Runtime.getRuntime().freeMemory();
    for (int j = 0; j < ts.length; j++)
        ts[j] = new Throwable();
    long used = free - Runtime.getRuntime().freeMemory();
    System.out.printf("Average Throwable size was %,d%n", used / ts.length);
}
System.gc();
for (int i = 0; i < 5; i++) {
    Throwable[] ts = new Throwable[10000];
    long free = Runtime.getRuntime().freeMemory();
    for (int j = 0; j < ts.length; j++)
        ts[j] = Throwable.class.newInstance();
    long used = free - Runtime.getRuntime().freeMemory();
    System.out.printf("Average Throwable.class.newInstance() size was %,d%n", used / ts.length);
}