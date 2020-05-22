public class AVLTreeTest {

  public static void main(String[] args) {

    Comparator myComp2 = new Comparator<AVLNode>() {
      @Override
      public int compare(AVLNode n1, AVLNode n2) {
        return ((String)n1.getKey()).compareTo((String)n2.getKey());
      }
    };

    AVLNode<String, AVLNode> a1 = new AVLNode("test3", "asd");
    AVLNode<String, AVLNode> a2 = new AVLNode("test2", "bds");
    AVLNode<String, AVLNode> a3 = new AVLNode("test8", "asdfas");
    AVLNode<String, AVLNode> a4 = new AVLNode("test1", "asdfasdf");

    List<AVLNode> listOfNodes = new ArrayList<AVLNode>();
    listOfNodes.add(a1);
    listOfNodes.add(a2);
    listOfNodes.add(a3);
    listOfNodes.add(a4);
    Collections.sort(listOfNodes, myComp2);

    for (AVLNode node : listOfNodes) {
      System.out.println(node);
    }
  }
}

class AVLNode<K, V> {

  private AVLNode<K, V> left, right, parent;
  private int height = 1;
  private K key;
  private V value;

  public AVLNode() {
  }

  public AVLNode(K key, V value) {
    this.key = key;
    this.value = value;
  }


  public V getValue() {
    return value;
  }

  public K getKey() {
    return key;
  }

  @Override
  public String toString() {
    return "AVLNode{" +
        "left=" + left +
        ", right=" + right +
        ", parent=" + parent +
        ", height=" + height +
        ", key=" + key +
        ", value=" + value +
        '}';
  }
}