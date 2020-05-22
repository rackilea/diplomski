int min(Integer... nums) {
    if (nums.length == 0)
        throw new IllegalArgumentException("???");
    int res = nums[0];
    for (int i = 1; i < nums.length; ++i)
        res = Math.min(res, nums[i]);
    return res;
}