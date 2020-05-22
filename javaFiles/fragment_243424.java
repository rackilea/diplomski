public int binary_search(int[] nums, int start, int end, int target) {
    if (start > end) {
        return -1;
    }
    int mid = (start + end) / 2;
    if (nums[mid] == target) {
        return mid;
    } else {
        if (nums[mid] < target) {
            return binary_search(nums, mid + 1, end, target);
        } else {
            return binary_search(nums, start, mid - 1, target);
        }
    }
}

public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    ArrayList<List<Integer>> solution_set = new ArrayList<>();

    // you can't do it using only one loop.
    // Take a look at this sample input -2,0,1,1,2.
    // Here you have to consider for nums[i] and nums[j] -2, 0 as well as
    // -2, 1
    for (int i = 0; i < nums.length - 2; i++) {
        // skip duplicates
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }

        for (int j = i + 1; j < nums.length - 1; j++) {
            int number_1 = nums[i];
            int number_2 = nums[j];

            // skip duplicates and, since array is sorted, don't need to
            // consider values > 0
            if (i != j - 1 && nums[j - 1] == nums[j] || number_1 + number_2 > 0)
                continue;

            int target = -(number_1 + number_2);

            // since array is sorted, start binary search only from j + 1
            int target_index = binary_search(nums, j + 1, nums.length - 1, target);
            if (target_index != -1) {
                List<Integer> submission = new ArrayList<>();

                submission.add(number_1);
                submission.add(number_2);
                submission.add(target);
                solution_set.add(submission);
            }
        }
    }

    return solution_set;
}