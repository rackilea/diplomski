public MyObject(final Object input, final FirstStrategy strategy) {
  this(input, (Strategy) strategy);
}

public MyObject(final Object input, final SecondStrategy strategy) {
  this(input, (Strategy) strategy);
}

private MyObject(final Object input, final Strategy strategy) {
  // ...
}