private final static long MB = 1024*1024;
static void memStats(String when)
{
    Runtime rt = Runtime.getRuntime();
    long max = rt.maxMemory();
    long tot = rt.totalMemory();
    long free = rt.freeMemory();
    System.out.printf(
        "mem(mb): %5d tot, %5d free %5d used %5d max %s\n",
         tot/MB, free/MB, (tot-free)/MB, max/MB, when);
}

// unit testing (optional)
public static void main(String[] args) {
    Deque<Integer> deck = new Deque<>();
    memStats("startup");
    for( int i =0; i < 500000;i++) {
        deck.addFirst(i);
    }
    memStats("after alloc");

    for( int i =0; i < 500000;i++) {
        deck.removeFirst();
    }
    memStats("after removal");
    Runtime.getRuntime().gc();
    memStats("after gc");

    System.out.println("end");
    try {
        TimeUnit.MINUTES.sleep(5);
    } catch (InterruptedException ex)
    {
    }
}