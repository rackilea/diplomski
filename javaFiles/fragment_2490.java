public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(nums.length);

        for (int num : nums) {
            queue.offer(num);
        }

        for (int i = 0; i < nums.length - k; i++) {
            queue.poll();
        }

        return queue.peek();
    }
}