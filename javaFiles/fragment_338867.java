public static void main(String ...args) {

    Metrics.addRegistry(new SimpleMeterRegistry());

    Timer timer = Metrics.timer("item.processing");
    for (int i = 0; i < 100; i++) {
        timer.record(i, TimeUnit.SECONDS);
    }

    System.out.println(timer.count());
    System.out.println(timer.mean(TimeUnit.SECONDS));
}