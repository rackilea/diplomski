import org.openjdk.jmh.annotations.GenerateMicroBenchmark;

public class Benchmark1
{
  static final List<Integer> list = new ArrayList(asList(1,2,3,4,5,6,7,8,9,10));
  static { for (int i = 0; i < 5; i++) list.addAll(list); }

  @GenerateMicroBenchmark
  public long testIterator() {
    long sum = 0;
    for (int i : list) sum += i;
    return sum;
  }
  @GenerateMicroBenchmark
  public long testIndexed() {
    long sum = 0;
    for (int i = 0; i < list.size(); i++) sum += list.get(i);
    return sum;
  }
  @GenerateMicroBenchmark
  public long testSublistIterator() {
    long sum = 0;
    for (int i : list.subList(1, list.size())) sum += i;
    return sum;
  }
  @GenerateMicroBenchmark
  public long testIndexedSublist() {
    long sum = 0;
    final List<Integer> l = list.subList(1, list.size());
    for (int i = 0; i < l.size(); i++) sum += l.get(i);
    return sum;
  }
}