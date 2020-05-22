public class Item implements Comparable<Item> {
  .. same stuff as above...

  public int compareTo(Item other) {
    return this.getAisle() - other.getAisle();
  }
}