public class ExpressionTreeNode {

    private ExpressionTreeNode left, right;
    private String content;

    public ExpressionTreeNode(ExpressionTreeNode left, ExpressionTreeNode right, String content) {
        this.left = left;
        this.content = content;
        this.right = right;
    }
}