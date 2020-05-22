public class Example {

public static class ValuedPoint extends Point {
  private double value;

  public ValuedPoint(double x, double y, double value) {
    super(x, y);
    this.value = value;
  }

  public double getValue() {
    return value;
  }

  public String toString() {
    return "{" + x + ", " + y + ", " + value + "}";
  }
}

private static class ValueComparator implements Comparator<ValuedPoint> {

  public int compare(ValuedPoint arg0, ValuedPoint arg1) {
    return Double.compare(arg0.getValue(), arg1.getValue());
   }
 }

public static void main(String[] args) {

  Set<ValuedPoint> set0 = new HashSet<ValuedPoint>();
  Set<ValuedPoint> set1 = new HashSet<ValuedPoint>();

  set0.add(new ValuedPoint(32, 59, 56));
  set0.add(new ValuedPoint(398, 3, 20));
  set0.add(new ValuedPoint(3, 3, 209));

  set1.add(new ValuedPoint(32, 596, 561));
  set1.add(new ValuedPoint(396, 311, 20));
  set1.add(new ValuedPoint(35, 34, 2099));

  System.out.println("set0.size:" + set0.size());
  System.out.println("set1.size:" + set1.size());

  Set<ValuedPoint> combined = new HashSet<ValuedPoint>();

  combined.addAll(set0);
  combined.addAll(set1);
  System.out.println("combined size:" + combined.size());

  ValueComparator comparator = new ValueComparator();

  List<ValuedPoint> sortedList = new ArrayList<ValuedPoint>(combined);
  Collections.sort(sortedList, comparator);

  System.out.println("list size:" + sortedList.size());
  System.out.println("sortedList:" + sortedList);
  }
}