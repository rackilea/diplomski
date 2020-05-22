public static void main(String[] args) throws DocumentException {
    SAXReader saxReader = new SAXReader();
    String xml = "<html><head><title>title</title></head><body><h1>title</h1></body></html>";
    Document document = saxReader.read(new StringReader(xml));

    List nodes = document.selectNodes("//*");
    for (Iterator<Node> iterator = nodes.iterator(); iterator.hasNext();) {
        Node currentNode = iterator.next();
        DefaultElement newElement = new DefaultElement("any");
        Element parent = currentNode.getParent();
        if (parent != null) {
            List contentList = parent.content();
            int index = contentList.indexOf(currentNode);
            parent.remove(currentNode);
            newElement.add(currentNode);
            contentList.add(index, newElement);
        }
    }

    Element rootElement = document.getRootElement();
    DefaultElement newRootElement = new DefaultElement("any");
    document.setRootElement(newRootElement);
    newRootElement.add(rootElement);
    System.out.println(document.asXML());
}