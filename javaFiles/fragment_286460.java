@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
public class SO30940682 {

  @Param({">aaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaa>",
          "aaaaaaaaaaaaaaaaaaaaap", "paaaaaaaaaaaaaaaaaaaaa"}) String s;

  @Benchmark public boolean stream() {
    return Stream.of(">", "<", "&", "l", "p").anyMatch(s::contains);
  }

  @Benchmark public boolean regex() {
    return s.matches("^.*?(>|<|&|l|p).*$");
  }
}