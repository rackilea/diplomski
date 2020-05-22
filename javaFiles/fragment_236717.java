class Splitter {
  public List<String> words = new ArrayList<>();
  public List<Integer> counts = new ArrayList<>();

  public void accept(String s) {
    if(s.contains("of")) {
      counts.add(s.split(" ").length);
    } else if(s.contains("for")) {
      words.add(s.substring(s.indexOf("for")));
    }
  }

  public Splitter merge(Splitter other) {
    words.addAll(other.words);
    counts.addAll(other.counts);
    return this;
  }
}
Splitter collect = strs.stream().collect(
  Collector.of(Splitter::new, Splitter::accept, Splitter::merge)
);
System.out.println(collect.counts);
System.out.println(collect.words);