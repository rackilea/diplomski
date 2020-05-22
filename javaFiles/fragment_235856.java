package tmpjavaproj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Test {

    public static class Node implements Comparable<Node> {
        public int number;
        public List<Node> child; // Although this should actually be called children, not child

        public int hashCode() {
            return number;
        }

        public boolean equals(Node node) {
            return number == node.number;
        }

        public int compareTo(Node node) {
            return number - node.number;
        }
    }

    public static void main(String[] args) throws Exception {
        String[] inputs = { "12", "121", "122", "123", "1211", "1212", "1231", "14", "141", "142", "1411", "25", "251", "2511", "2512", "252", "253" };

        Set<Node> roots = new TreeSet<>();

        for (String input : inputs) {
            Node node = new Node();
            node.number = Integer.parseInt(input);

            Node root = null;
            for (Node rootCandidate : roots) {
                if (input.startsWith(String.valueOf(rootCandidate.number))) {
                    root = rootCandidate;
                    break;
                }
            }
            if (root == null) {
                List<Node> rootsToChildren = new ArrayList<>();
                for (Node aRoot : roots) {
                    if (String.valueOf(aRoot.number).startsWith(String.valueOf(node.number))) {
                        rootsToChildren.add(aRoot);
                    }
                }
                if (!rootsToChildren.isEmpty()) {
                    node.child = rootsToChildren;
                    roots.removeAll(rootsToChildren);
                }
                roots.add(node);
            } else {
                Node parentCandidate = root;
                while (root != null) {
                    root = null;
                    if (parentCandidate.child != null) {
                        for (Node child : parentCandidate.child) {
                            if (input.startsWith(String.valueOf(child.number))) {
                                parentCandidate = child;
                                root = child;
                            }
                        }
                    }
                }
                if (parentCandidate.child == null) {
                    parentCandidate.child = new ArrayList<>();
                }
                parentCandidate.child.add(node);
            }
        }

        Map<String, Set<Node>> response = new HashMap<>();
        response.put("response", roots);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setSerializationInclusion(Include.NON_NULL);
        System.out.println(mapper.writeValueAsString(response));
    }
}