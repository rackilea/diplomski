import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.nodeTypes.NodeWithIdentifier;

public class Test {
    public static void main(String[] args) throws Exception {
        String javaSource = "class MyClass {" +
                            "  void main(String[] args) {" +
                            "    int a = 5, b = 6;" +
                            "    int c = a * b;" +
                            "    System.out.println(c);" +
                            "  }" +
                            "}";

        System.out.printf("%-28s %-12s %s%n", "Node.class.simpleName", "Identifier", "Node.toString()");
        System.out.printf("%-28s %-12s %s%n", "=====================", "==========", "===============");
        JavaParser.parse(javaSource).walk(node -> {
            String identifier = "";
            if (node instanceof NodeWithIdentifier)
                identifier = ((NodeWithIdentifier<?>) node).getIdentifier();
            System.out.printf("%-28s %-12s %s%n",
                              node.getClass().getSimpleName(),
                              identifier,
                              node.toString().replaceFirst("(?s)\\R.*", "..."));
        });
    }
}