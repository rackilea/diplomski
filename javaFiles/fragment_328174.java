public void generateProblems(Integer[] nums, int start) 
{

    if (start != nums.length) 
    {
        for (int i = -range; i < range; i++) 
        {
            nums[start] = nums[start] + i;

            action(nums);
            generateProblems(nums, start + 1);         

            nums[start] = nums[start] - i;
        }
    }
}