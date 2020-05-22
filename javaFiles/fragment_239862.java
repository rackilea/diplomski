public class linklist {
class ListNode {
    int item;
    ListNode next;
}

ListNode root;

public linklist() {
    this.root = null;
}
    public void add(ListNode node){ /*...*/}
    public int getMax() {
    if (root == null)
        throw new NullPointerException("No items in list");
    return getMaxFrom(this.root, this.root.item);
}

int getMaxFrom(ListNode node, int maxValue) {
    if (node == null)
        return maxValue;
    else {
        return getMaxFrom(node.next, Math.max(node.item, maxValue));
    }
}
}