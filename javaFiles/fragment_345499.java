private static final ImmutableSet<String> OPTIONAL_CLASSES =
      ImmutableSet.of(com.google.common.base.Optional.class.getName(), "java.util.Optional");

private static final Set<Kind> COMPARISON_OPERATORS =
          EnumSet.of(Kind.EQUAL_TO, Kind.NOT_EQUAL_TO);

private static boolean isNull(ExpressionTree tree) {
    return tree.getKind() == Kind.NULL_LITERAL;
}

private static boolean isOptional(ExpressionTree tree, VisitorState state) {
        Type type = ASTHelpers.getType(tree);
    for (String className : OPTIONAL_CLASSES) {
            if (ASTHelpers.isSameType(type, state.getTypeFromString(className), state)) {
                    return true;
            }
    }
    return false;
}

private boolean isSuppressed(Tree tree, String suppression) {
    SuppressWarnings annotation = ASTHelpers.getAnnotation(ASTHelpers.getSymbol(tree), SuppressWarnings.class);
    return annotation != null && Arrays.stream(annotation.value()).anyMatch(suppression::equals);
}

@Override
public Description matchBinary(BinaryTree tree, VisitorState state) {
    if (!COMPARISON_OPERATORS.contains(tree.getKind())) {
        return Description.NO_MATCH;
    }

    ExpressionTree leftOperand = tree.getLeftOperand();
    ExpressionTree rightOperand = tree.getRightOperand();
    if (isNull(leftOperand) && isOptional(rightOperand, state) ||
            isNull(rightOperand) && isOptional(leftOperand, state)) {
            return describeMatch(tree);
    }

    return Description.NO_MATCH;
}