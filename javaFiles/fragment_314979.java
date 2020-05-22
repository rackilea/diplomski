public class BooleanNode extends Node<Boolean> {
    public BooleanNode(boolean defaultValue) {
        super(defaultValue,
              s -> Boolean.parseBoolean(s)); // or use a static parser as in the factory example
    }
}