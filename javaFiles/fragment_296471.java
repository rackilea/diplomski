private Element node;

private final StringProperty key;
private final StringProperty val;

public ElementWrapper(Element n){
    System.out.println("creating element " + n.getNodeName());
    node = n;
    key = new SimpleStringProperty(this, node.getAttribute("key"));
    val = new SimpleStringProperty(this, node.getAttribute("val"));
}