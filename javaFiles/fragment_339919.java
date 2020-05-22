class NodeWrapper
{
  TreeNode node;
}

class TreeNode
{
  ...
  TreeNode(int num)
  {
    leftChild = new NodeWrapper();
    rightChild = new NodeWrapper();
    ...
  }
  NodeWrapper leftChild, rightChild;
}

void readBSTHelper(NodeWrapper curr, Queue<Integer> input, int min, int max)
{
  ...
}