public static void sleep(long millis)
{
    try { Thread.sleep((long) (Math.random() * 30 + millis)); } catch (InterruptedException e) { }
}

streamForked(Stream.of("1", "2", "3", "4", "5"),
             source -> source.map(word -> { sleep(50); return "fast   " + word; }).forEach(System.out::println),
             source -> source.map(word -> { sleep(300); return "slow      " + word; }).forEach(System.out::println),
             source -> source.map(word -> { sleep(50); return "2fast        " + word; }).forEach(System.out::println));

fast   1
2fast        1
slow      1
fast   2
2fast        2
slow      2
2fast        3
fast   3
slow      3
fast   4
2fast        4
slow      4
2fast        5
fast   5
slow      5