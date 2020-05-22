public class Test {
    public static void main(String[] args) throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><html> <body> <h1 align=\"center\">Profile</h1><hr /> <div class=\"centered\"> <table><tr><td><strong>Name: </strong></td> <td>A</td> </tr> <tr> <td><strong>Age: </strong></td> <td>23</td> <td>programmer</td></tr><tr><td><strong>Email: </strong></td><td>adfg@gmail.com</td></tr></table></div><hr /></body></html>";
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(new StringReader(xml));
        listChildren(doc.getRootElement(), 0);
    }

    private static void listChildren(Element root, int depth) {
        System.out.println(root.getName());
        List<Element> children = root.getChildren();
        if (children == null || children.isEmpty())
                return;
        for (Element child : children) {
                 System.out.println(child.toString());
                 listChildren(child, depth+1);
        }

        return;
    }
}