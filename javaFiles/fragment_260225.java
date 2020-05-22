@Bean
public IntegrationFlow flow() {
  return IntegrationFlows.from("input")
    .split(s -> s.delimiters(" "))
    .scatterGather(
      sc -> sc
        .applySequence(true)
        .recipientFlow(m -> true, f1 -> f1.handle((p, h) -> p + " - flow 1"))
        .recipientFlow(m -> true, f2 -> f2.handle((p, h) -> p + " - flow 2")),
      null
    )
    .transform((List<String> l) -> l.stream().collect(Collectors.joining(", ")))
    .aggregate()
    .transform((List<String> source) -> source.stream()
      .map(s -> "- " + s)
      .collect(Collectors.joining("\n")))
    .get();
}