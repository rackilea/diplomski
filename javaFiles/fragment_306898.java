public int lengthOfLIS(int[] nums) {
    return lengthOfLIS(nums, 0, 0, -1);
}

public int lengthOfLIS(int[] nums, int carry, int index, int max){
    if(nums.length == 0){
        return 0;
    }

    if(nums[index] > max) {
        carry++;
        max = nums[index];
    }

    int max_carry = carry;
    for (int i = index; i < (nums.length - 1); i++) {
        int temp_carry = lengthOfLIS(nums, carry, i + 1, max);
        if (temp_carry > max_carry) {
          max_carry = temp_carry;
        }
    }
    return max_carry;
}