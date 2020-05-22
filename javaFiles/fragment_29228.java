public void pathToSum(int sum) {
    pathToSum(root, sum);
}

private boolean pathToSum(Node n, int sum) {
    if (null != n) {
        sum -= n.data;
        boolean found = pathToSum(n.left, sum);

        if (!found) {
            found = pathtoSum(n.right, sum);
        }
        if (found) {
            println(n.data);
                            return found;
        }
    }
    return 0 == sum ? true : false;
}