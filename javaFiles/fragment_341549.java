public class Node<T>

    protected T data;
    protected Node<T> left;
    protected Node<T> right;

    public String tuple() {
        StringBuilder sb = new StringBuilder("(")
                .append(this.data)
                .append(",");
        sb.append(this.left == null ? "*" : this.left.data)
                .append(",");
        sb.append(this.right == null ? "*" : this.right.data)
                .append(")");
        return sb.toString();
    }

    // other methods
}