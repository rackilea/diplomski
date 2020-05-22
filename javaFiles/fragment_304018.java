public static <T> T findkthInOrder(Node<T> root, int k) {
    return findkthInOrder(root, k, new int[]{0});
}
public static <T> T findkthInOrder(Node<T> root, int k, int[] count) {
    if (root == null)
        return null;
    T rt = findkthInOrder(root.left, k, count);
    if (rt != null)
        return rt;
    count[0]++;
    if (count[0] == k) {
        return root.data;
    }
    return findkthInOrder(root.right, k, count);
}