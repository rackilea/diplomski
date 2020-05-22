private final Consumer<String> barConsumer = this::bar;
private final Consumer<String> fooConsumer = this::foo;
private final List<Consumer<String>> activities = ImmutableList.of(barConsumer, fooConsumer);

public void print() {
    System.out.println(activities.indexOf(fooConsumer);
}