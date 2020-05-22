@interface NodeInfo {
    LogicalExpression logicalExpression() default LogicalExpression.AND;
    Attribute[] attributes() default {};
}


@interface Node {
    NodeInfo[] nodes() default {};
}