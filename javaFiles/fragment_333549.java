if (k==1) {
    ListNode removedNode = firstNode;
    firstNode = firstNode.nextNode;
    return removedNode;
}
ListNode someNode = firstNode;
for (int i = 1; i < k - 1; i++) {
    someNode = someNode.nextNode;
}
ListNode removedNode = someNode.nextNode;
someNode.nextNode = someNode.nextNode.nextNode;
return removedNode;