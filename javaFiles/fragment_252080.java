class Balance {
  public static void main(String[] args) {
    System.out.println(balanced(-3, 5, 12, 14, -9, 13));   // true
    System.out.println(balanced(-3, 5, -12, 14, -9, 13));  // false
  }

  private static boolean balanced(int... nums) {
    // First check if there are an even number of nums.
    return nums.length % 2 == 0
        // Now start the recursion:
        && balanced(
            0, 0,  // Zero numbers on the left, summing to zero.
            0, 0,  // Zero numbers on the right, summing to zero.
            nums);
  }

  private static boolean balanced(
      int leftCount, int leftSum,
      int rightCount, int rightSum,
      int[] nums) {
    int idx = leftCount + rightCount;
    if (idx == nums.length) {
      // We have attributed all numbers to either side of the equation.
      // Now check if there are an equal number and equal sum on the two sides.
      return leftCount == rightCount && leftSum == rightSum;
    } else {
      // We still have numbers to allocate to one side or the other.
      return
          // What if I were to place nums[idx] on the left of the equation?
          balanced(
              leftCount + 1, leftSum + nums[idx],
              rightCount, rightSum,
              nums)
          // What if I were to place nums[idx] on the right of the equation?
          || balanced(
              leftCount, leftSum,
              rightCount + 1, rightSum + nums[idx],
              nums);
    }
  }
}