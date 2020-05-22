@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Node<?> node = (Node<?>) o;

    if (left != null ? !left.equals(node.left) : node.left != null) return false;
    if (right != null ? !right.equals(node.right) : node.right != null) return false;
    if (parent != null ? !parent.equals(node.parent) : node.parent != null) return false;
    return value != null ? value.equals(node.value) : node.value == null;

}

@Override
public int hashCode() {
    int result = left != null ? left.hashCode() : 0;
    result = 31 * result + (right != null ? right.hashCode() : 0);
    result = 31 * result + (parent != null ? parent.hashCode() : 0);
    result = 31 * result + (value != null ? value.hashCode() : 0);
    return result;
}