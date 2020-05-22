Node reverse(Node ptr, Node acc) {
    if (ptr == null)
        return acc;
    Node second = ptr.link;
    ptr.link = acc;
    return reverse(second, ptr);
}