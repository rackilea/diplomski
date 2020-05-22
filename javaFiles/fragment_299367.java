public int sumValues() {
    System.out.println(info + " ");
    int sum = info; // account for current node

    if (left != null)
        sum += left.sumValues(); // add sum of left subtree

    if (right != null)
        sum += right.sumValues(); // add sum of right subtree

    return sum;
}