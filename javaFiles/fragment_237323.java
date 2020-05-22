public static Node buildBinarytreefromPostOrder(int[] post, int start, int end)
{
    if (end < start)
        return null;

    Node root = new Node(post[end]);

    if (end == start)
        return root;

    int i;
    for (i = end; i >= start; i--)
        if (post[i] < root.data)
            break;

    root.left = buildBinarytreefromPostOrder(post, start, i);
    root.right = buildBinarytreefromPostOrder(post, i + 1, end - 1);

    return root;
}