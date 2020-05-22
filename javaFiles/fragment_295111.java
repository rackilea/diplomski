String[] nums = lotto.split(" ");
    int[] a = new int[nums.length];
    for(int i = 0; i < a.length; i++)
    {
        a[i] = Integer.parseInt(nums[i]);
    }
    return a;