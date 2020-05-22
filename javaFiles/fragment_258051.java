public class DataSet {

  // Usage example
  public static void main (String [] args) {

    DataSet nn = new DataSet ();
    nn.add(0.2,1);
    nn.add(0.3,2);
    nn.add(0.4,3);
    nn.add(0.6,4);
    nn.add(0.8,5);
    nn.add(0.9,6);
    nn.add(1.0,7);

    int n = 5;
    int m = 2;
    double v = 0.5;

    ListIterator <Pair> it = nn.iterator(v);
    for (int i=0; i<m; ++i)
      it.previous();      
    for (int i=0; i<n; ++i)
      System.out.append(it.next()+"\n");
  }

  // Implementation
  TreeSet <Pair> set = new TreeSet <Pair> (new PairComparator());
  ArrayList <Pair> list = new ArrayList <Pair> ();
  boolean listUpToDate = false;

  // Add data
  boolean add (double x, double y) {
    listUpToDate = false;
    return set.add(new Pair(x,y));
  }

  // Get iterator at specified position
  ListIterator <Pair> iterator (double v) {
    if (!listUpToDate) {
      list = new ArrayList (set);
      listUpToDate = true;
    }
    int pos = Collections.binarySearch(list,v);
    if (pos < 0)
      pos = -pos - 1;
    return list.listIterator(pos);
  }

  // Helper class
  static class Pair implements Comparable <Double> {
    double x, y;
    Pair (double x, double y) {
      this.x = x; this.y = y;
    }
    public int compareTo (Double d) {
      return Double.valueOf(x).compareTo(d);
    }
    public String toString () {
        return String.format("[%.1f,%.1f]",x,y);
    }
  }

  // Used for sorting
  class PairComparator implements Comparator <Pair> {
    public int compare (Pair n0, Pair n1) {
      return Double.valueOf(n0.x).compareTo(Double.valueOf(n1.x));
    }
  }

}