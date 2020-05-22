@javax.faces.bean.ManagedBean(name = "tree")
@javax.faces.bean.RequestScoped
public class Tree {
  private Node<String> root = new Node(null, "JSF Stuff");

  @PostConstruct
  public void initData() {
    root.getKids().add(new Node(root, "Chapter One"));
    root.getKids().add(new Node(root, "Chapter Two"));
    root.getKids().add(new Node(root, "Chapter Three"));
    Node<String> chapter2 = root.getKids().get(1);
    chapter2.getKids().add(new Node(chapter2, "Section A"));
    chapter2.getKids().add(new Node(chapter2, "Section B"));
  }

  public List<Node<String>> getTreeNodes() {
    return walk(new ArrayList<Node<String>>(), root);
  }

  private List<Node<String>> walk(List<Node<String>> list, Node<String> node) {
    list.add(node);
    for(Node<String> kid : node.getKids()) {
      walk(list, kid);
    }
    return list;
  }
}