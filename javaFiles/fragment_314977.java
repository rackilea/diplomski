public class Node<T> {
    private T defaultValue;
    private Function<String, T> parser;

    public Node(T defaultValue,
                Function<String, T> parser) {
        this.defaultValue = defaultValue;
        this.parser = parser;
    }

    public T getValue()
    {
        // depending on the parser, re-parsing every time this is called could get expensive!
        try
        {
            // here will be some logic to get String value from some db or any other source
            String input = "true";
            return parser.apply(input);
        } catch (Exception e) {
            return defaultValue;
        }
    }
}