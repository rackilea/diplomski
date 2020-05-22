public static <T> T findkthInOrder(Node<T> root, int k) {
    return findkthInOrder(root, k, new AtomicInteger(0));
}
public static <T> T findkthInOrder(Node<T> root, int k, AtomicInteger count) {
    if (root == null)
        return null;
    T rt = findkthInOrder(root.left, k, count);
    if (rt != null)
        return rt;
    if (count.incrementAndGet() == k) {
        return root.data;
    }
    return findkthInOrder(root.right, k, count);
}