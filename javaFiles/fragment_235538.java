public class Test {
  public void x() {
    Node n = new Node();
    n.pivot = null;
    n.pivotIndex = 0;
  }
  private class Node {
    public int[] pivot;
    public int pivotIndex;
  }
}