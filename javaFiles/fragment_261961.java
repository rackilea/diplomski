private static ExpressionTreeNode createExpressionTree(String[] tokens) {
    final Stack<ExpressionTreeNode> nodes = new Stack<ExpressionTreeNode>();

    for (int i = 0; i < tokens.length; i++) {
        String token = tokens[i];

        if (Operator.isOperator(token)) {
            ExpressionTreeNode rightNode = nodes.pop();
            ExpressionTreeNode leftNode = nodes.pop();
            nodes.push(new ExpressionTreeNode(leftNode, rightNode, token));
        } else {
            nodes.add(new ExpressionTreeNode(null, null, token));
        }
    }

    return nodes.pop();
}