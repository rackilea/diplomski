public boolean isEverywhere(int[] nums, int value) {

    for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] != value && nums[i + 1] != value) {
            return false;
        }
    }

    return true;
}