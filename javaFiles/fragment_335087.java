int[] nums = new int[max];
for (int i = 0; i < max; i++)
    nums[i] = i;
Collections.shuffle(Arrays.asList(nums));
for (int i = 0; i < n; i++)
    differentArray[i] = nums.get(i);