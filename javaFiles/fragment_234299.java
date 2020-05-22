public class LimitedArrayList extends ArrayList<String> {
  @Override
  public boolean add(String e) {
      if (this.size() == 10) {
          // Remove an item or return
      }
      return super.add(e);
      // Or add as first item
      // return add(0, e);
  }
  public void add(int index, String e) {
      if (this.size() == 10) {
          // Remove an item or return
      }
      super.add(index, e);
  }
}