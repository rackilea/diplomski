private int addSumUtil(Node node, int sum)
{
    if (node == null) {
        return sum;
    }

    sum = addSumUtil(node.rightChild, sum);
    sum = node.item += sum;
    sum = addSumUtil(node.leftChild, sum);

    return sum;
}