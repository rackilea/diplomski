public PrintWriter bstToXML() {
    try (PrintWriter pw = new PrintWriter("tree.xml")) {
        pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        bstToXMLHelper(this.root, pw, "root");
        return pw;
    } catch (IOException e) {
        e.printStackTrace();
    }

    return null;
}

private void bstToXMLHelper(BSTNode node, PrintWriter pw, String place) {
    if(node == null) {
        return;
    }

    pw.println("<node place=\"" + place + "\">" + node.el.toString());

    if(node.left != null){
        bstToXMLHelper(node.left, pw, "left");
    }

    if(node.right != null) {
        bstToXMLHelper(node.right, pw, "right");
    }

    pw.println("</node>");
}