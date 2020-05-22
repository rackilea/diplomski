abstract class AandBComparable implements Comparable {

  public int compareTo(Object o) {
    AandBComparable ab = (AandBComparable) o;
    return getId().compareTo(ab.getId());
  }

  public abstract String getId();
}