public class NodeFactory {
    private static final Function <String, Boolean> BOOLEAN_PARSER = s -> Boolean.parseBoolean(s);
    .// plus more for integers, double, etc, as required

    private NodeFactory() {
        // no-op
    } 

    public static Node<Boolean> booleanNode(boolean defaultValue){
        return new Node<Boolean>(defaultValue,
                                 BOOLEAN_PARSER);
    }

    // plus more for integer, double, etc, as required
}