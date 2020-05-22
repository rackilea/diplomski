public boolean haveThree(int[] nums) {
    if(nums.length <= 0) //hint, although a length is never negative, one better uses "strong conditions"
        return false;
    int count=0;
    for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] == 3 && nums[i + 1] == 3)
            return false;
        if (nums[i] == 3)
            count++;
    }
    if (nums[nums.length-1] == 3)
        count++;
    return(count==3);
}