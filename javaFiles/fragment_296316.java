public class Container implements Exportable {
    private Node root;
    private String name;

    @Override
    public void exportXML(org.w3c.dom.Node target, Document document) {
        Element node = document.createElement("container");
        document.appendChild(node);
        node.setAttribute("name", name);

        root.exportXML(target, document);
    }
}