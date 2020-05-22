@Test
public void writesOnlyOnce() {
    List<Integer> output = new ArrayList<>();

    Consumer<Supplier<Integer>> consumer = consumeOnlyOnce(num -> output.add(num));

    consumer.accept(() -> 5); // body of supplier could be much more complex
    consumer.accept(() -> 3);

    assertThat(output, is(Collections.singletonList(5)));

}

public Consumer<Supplier<Integer>> consumeOnlyOnce(Consumer<Integer> handler) {
    final boolean[] done = new boolean[] { false };

    return supplier -> {
        if (!done[0]) {
            handler.accept(supplier.get());
        }
        done[0] = true;
    };
}