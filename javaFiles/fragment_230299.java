public class ExampleComparator implements Comparator<YourObject> {

  public int compare(YourObject o1, YourObject o2) {
    if (o1 == null || o2 == null) {
      throw new NullPointerException();
    }

    if (o1.getValue1() != o2.getValue1()) {
      return Integer.compare(o1.getValue1(), o2.getValue1());
    }

    return Integer.compare(o1.getValue2(), o2.getValue2());
  }
}