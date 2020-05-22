public class Solution {
  public TreeNode root;

  private static class TreeNode {
    private String val;
    private TreeNode left, right;

    public TreeNode(String x) {
      this.val = x;
    }
  }

  public static int sum = 0;

  public static int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    }

    sumOfLeftLeavesRec(root, false);
    return sum;
  }

  public static void sumOfLeftLeavesRec(TreeNode x, boolean isLeft) {
    if (x == null) {
      return;
    }

    if (x.left == null && x.right == null && isLeft) {
      sum += Integer.valueOf(x.val);
    }

    sumOfLeftLeavesRec(x.left, true);
    // As debug model check, if just use static memeber variable sum could not
    // keep the value when return from deepest recursion, e.g when return from
    // node 8, the sum should be 8 and pass into new recursion on node 6(which
    // return from recursion of node 8), but real situation is sum will change
    // back to 0.
    sumOfLeftLeavesRec(x.right, false);
  }

  public static void main(String[] args) {
     /*
      * The tree used for test
      *        1
      *      /   \
      *     2     3
      *    / \   /
      *   6   5 9
      *  /
      * 8
     */
    Solution s = new Solution();
    s.root = new TreeNode("1");
    s.root.left = new TreeNode("2");
    s.root.right = new TreeNode("3");
    s.root.left.left = new TreeNode("6");
    s.root.left.right = new TreeNode("5");
    s.root.left.left.left = new TreeNode("8");
    s.root.right.left = new TreeNode("9");

    int result = sumOfLeftLeaves(s.root);
    System.out.println(result);
  }
}