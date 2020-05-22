public <T extends Node> void validateNodeForEmptyByPredicate(
    T node,
    PseudoClass errorClass,
    Predicate<T> predicate
) {
    node.focusedProperty().addListener((arg0, oldValue, newValue) -> {
        if (!newValue) {
            node.pseudoClassStateChanged(errorClass, predicate.test(node)); // *
        }
    });
}