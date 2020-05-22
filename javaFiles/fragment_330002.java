public class TestJson {
    static abstract class Node {
    }

    static class IntermediateNode extends Node {
        public Map<String, Node> keyValueMap = new LinkedHashMap<>();

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append(keyValueMap.entrySet().stream().map(entry -> entry.getKey() + " : " + entry.getValue())
                       .collect(Collectors.joining(", ")));

            sb.append("}");
            return sb.toString();
        }
    }


    static class LeafNode extends Node {
        public String value;

        @Override
        public String toString() {
            return value;
        }
    }


    public static void main(String[] args) {
        String testString =
                "Person.City.FirstNm.LastNm=xyz, Person.City.Address=abc, Person.City.FirstNm.Salary=1000.24, Person"
                + ".State.FirstNm.LastNm=xyz";

        IntermediateNode root = new IntermediateNode();
        for (String param : testString.replaceAll(" ", "").split(",")) {
            String[] def = param.split("=");

            String[] result = def[0].split("\\.");
            IntermediateNode currentNode = root;
            for (int i = 0; i < result.length - 1; i++) {
                Node node = currentNode.keyValueMap.get(result[i]);
                if (node == null) {
                    IntermediateNode child = new IntermediateNode();
                    currentNode.keyValueMap.put(result[i].trim(), child);
                    currentNode = child;
                } else {
                    currentNode = (IntermediateNode) node;
                }
            }
            LeafNode leaf = new LeafNode();
            leaf.value = def[1];
            currentNode.keyValueMap.put(result[result.length - 1], leaf);
        }

        System.out.println(root);
    }
}