public enum Operator {
    EQUAL("=="),
    NOT_EQUAL("<>"),
    GREATER_THAN(">"),
    GREATER_THAN_OR_EQUAL(">="),
    LESS_THAN("<"),
    LESS_THAN_OR_EQUAL("<=");

    private final String representation;

    private Operator(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }
}