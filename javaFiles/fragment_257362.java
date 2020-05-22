List<Strategy> strategies = // initialize your strategies

list.forEach((item) -> {
  strategies.stream()
    .filter((s) -> s.accepts(item)) // find the appropriate strategy
    .findFirst()                    // if we found it
    .ifPresent(strategy -> strategy.process(item)); // apply it
    // or use .getOrElseThrow to fail fast if no strategy can be found
});