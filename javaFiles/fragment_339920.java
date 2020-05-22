class TreeNode
{
  ...
  TreeNode()
  {
    val = null;
  }
  TreeNode(int num)
  {
    init(num);
  }
  init(int num)
  {
    leftChild = new TreeNode();
    rightChild = new TreeNode();
    val == num;
  }
  Integer val;
}

public void readBST(Queue<Integer> input){
    if (input==null || input.isEmpty()) return;     
    int i=input.poll();
    root2 = new TreeNode(i);
    if (!readBSTHelper(root2.leftChild , input, Integer.MIN_VALUE , i-1))
      root2.leftChild = null; // delete child if not populated
    if (!readBSTHelper(root2.rightChild, input, i+1, Integer.MAX_VALUE))
      root2.rightChild = null; // delete child if not populated
}

boolean readBSTHelper(TreeNode curr, Queue<Integer> input, int min, int max){
    if (input==null && input.isEmpty()) return false;
    int i = input.peek();
    if (i>=min && i<=max){
        input.poll();
        curr.init(i);
        if (!readBSTHelper(curr.leftChild, input, min, i-1))
          curr.leftChild = null;
        if (!readBSTHelper(curr.rightChild, input, i+1, max))
          curr.rightChild = null;
        return true;
    }
    return false;
}