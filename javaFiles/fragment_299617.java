public enum MyFanout {
    MY_FANOUT(Lists.newArrayList("queue1", "queue2"), "my-fanout"),

    private final List<String> queueNames;
    private final String fanoutName;

    MyFanout(final List<String> queueNames, final String fanoutName) {
        this.queueNames = requireNonNull(queueNames, "queue must not be null!");
        this.fanoutName = requireNonNull(fanoutName, "exchange must not be null!");
    }

    public List<String> getQueueNames() {
        return this.queueNames;
    }

    public String getFanoutName() {
        return this.fanoutName;
    }
}