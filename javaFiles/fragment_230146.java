public int pathSum(TreeNode n, Stack<Integer> acc, int sum){
    if(n == null){
        return 0;
    }

    int count = 0;
    int totalToNode = acc.peek() + n.val;

    //increment count, if the nodes value matches (path of length 1)
    if(n.val == sum)
        count++;

    //increment count, if the path from root to n sums up to the given value
    if(totalToNode == num)
        count++;

    //find all paths that end in n and sum up to the searched sum
    for(int s : acc)
        if(totalToNode - s == sum)
            count++;

    acc.push(totalToNode);

    //number of matching paths for left and right subtree
    count += pathSum(n.left, acc, sum);
    count += pathSum(n.right, acc, sum);

    acc.pop();

    return count;
}