import java.text.MessageFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Triangle> foundTriangles = new HashSet<Triangle>();
        Map<Integer, Node> graph = new HashMap<Integer, Node>();
        Couple[] a = new Couple[] { new Couple(0, 1), 
                                    new Couple(2, 1), 
                                    new Couple(0, 2), 
                                    new Couple(4, 1) };
        // build graph
        for (Couple couple : a) {
            int start = couple.getStart();
            Node node1 = graph.get(start);
            if (node1 == null) {
                node1 = new Node(start);
                graph.put(start, node1);
            }
            int end = couple.getEnd();
            Node node2 = graph.get(end);
            if (node2 == null) {
                node2 = new Node(end);
                graph.put(end, node2);
            }
            node1.addAdjacentNode(node2);
            node2.addAdjacentNode(node1);
        }
        // search for triangles in the graph
        for (Node root : graph.values()) {
            Set<Node> nodes = root.getNodes(); // A
            for (Node root2 : nodes) { // B
                if (!root2.equals(root)) { // prevent going back
                    Set<Node> nodes2 = root2.getNodes();
                    for (Node root3 : nodes2) { // C
                        if (!root3.equals(root2)) { 
                            Set<Node> nodes3 = root3.getNodes();
                            for (Node node4 : nodes3) {// A
                                if (!node4.equals(root3)) { 
                                    if (node4.equals(root)) { 
//                                      String message = 
//                                      MessageFormat.format(
//                                          "Found triangle: {0}{1}{2}",
//                                          root.getValue(),
//                                          root2.getValue(), 
//                                          root3.getValue());
//                                      System.out.println(message);
                                        Triangle t = new Triangle(root,
                                                                  root2, 
                                                                  root3);
                                        foundTriangles.add(t);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(foundTriangles);
    }
}