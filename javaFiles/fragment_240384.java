ArrayList<int[]> nums = new ArrayList<>();
    nums.add(new int[] { 1, 2 });
    nums.add(new int[] { 3, 4 });
    nums.add(new int[] { 5, 6 });

    for(int[] n : nums)
    {
        System.out.println(n[0] + " : " + n[1]);
    }

    nums.add(0, new int[] { 0, 0 });

    for(int[] n : nums)
    {
        System.out.println(n[0] + " : " + n[1]);
    }