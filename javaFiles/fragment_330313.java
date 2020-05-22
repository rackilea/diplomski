@Override
public A read(InputNode node) throws Exception {
    final StringBuilder sb = new StringBuilder(1024);
    concatNodesTree(sb, node);

    A a = new A();
    a.content = sb.toString();
    return a;
}

private void concatNodesTree(StringBuilder sb, InputNode root) throws Exception {

    if (root.isElement()) {
        sb.append("<").append(root.getName()).append(">");
    }

    String value = root.getValue();
    if (value != null) {
        sb.append(value);
    }

    InputNode node = root.getNext();
    while (node != null) {
        concatNodesTree(sb, node);

        // Each time a sub-tree is 'over', getValue() will deserialize the potentially upcoming free-text
        value = root.getValue();
        if (value != null) {
            sb.append(value);
        }
        node = root.getNext();
    }

    if (root.isElement()) {
        sb.append("</").append(root.getName()).append(">");
    }
}