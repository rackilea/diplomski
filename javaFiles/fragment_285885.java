int[] nums = ...;
for (int num : nums)
{
    System.out.println(num);
}

// equivalent to:
int[] nums = ...;
for (int i=0; i<nums.length; i++)
{
    int num = nums[i];
    System.out.println(num);
}