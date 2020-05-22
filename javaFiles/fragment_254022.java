public class CommandOne extends HystrixCommand<String> {

    private String content;
    public static int runCount = 0;


    public CommandOne(String s) {
        super(Setter.withGroupKey
                (HystrixCommandGroupKey.Factory.asKey("SnapshotIntervalTest"))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                                .withCircuitBreakerSleepWindowInMilliseconds(500000)
                                .withCircuitBreakerRequestVolumeThreshold(9)
                                .withMetricsHealthSnapshotIntervalInMilliseconds(50)
                                .withMetricsRollingStatisticalWindowInMilliseconds(100000)
                )
        );
        this.content = s;
    }

    @Override
    public String run() throws Exception {
        Thread.sleep(100);
        runCount++;
        if ("".equals(content)) {
            throw new Exception();
        }
        return content;
    }

    @Override
    protected String getFallback() {
        return "FAILURE-" + content;
    }

}

    @Test
    void test() {

        for (int i = 0; i < 100; i++) {
            CommandOne commandOne = new CommandOne();
            commandOne.execute();
        }
        Assertions.assertEquals(10, CommandOne.runCount);
    }