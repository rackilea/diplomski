import com.thoughtworks.xstream.XStream;


public class NodeXStream {

    public static void main(String[] args) {
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");

        n1.addNode(n2);
        n1.addNode(n3);

        n2.addNode(n4);
        n3.addNode(n5);


        XStream xs = new XStream();
        xs.processAnnotations(Node.class);

        // To XML
        String myXML = xs.toXML(n1);

        // From XML
        Node newNode = (Node) xs.fromXML(myXML);

    }

}