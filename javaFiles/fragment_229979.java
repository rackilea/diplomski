public int calculateSum(MyList list) {
    Node node = list.head();
    int sum = 0;
    while (node != null) {
        sum += node.value();
        node = node.next();
    }
    return sum;
}