if (nums.length > index_next) 
{
    if (nums[index] == 6)
        return true;

    // you have to return the result of the function here
    // in order to obtain an effective recursion, otherwise the
    // method is called but it's output value is ignored and the
    // functions goes outside the scope of the if statement
    // reaching the "return false" located at the bottom
    return array6(nums, index_next);
}