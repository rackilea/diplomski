public void addNums(int[] nums) {
    int[] list = new int[group.length + nums.length];
    for (int a = 0; a < group.length; a++)
        list[a] = group[a];

    for (int a = group.length; a < list.length; a++)
        list[a] = nums[a -group.length];
    group = list;
}