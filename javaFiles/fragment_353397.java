boolean helperResponse1 = helper(start + 1, nums, sum1 + nums[start], sum2);

if (helperResponse1 == true)
    return true;
else {
    boolean helperResponse2 = helper(start + 1, nums, sum1, sum2 + nums[start]);
    if (helperResponse2 == true)
        return true;
    else
        return false;
}