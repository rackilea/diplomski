int[] nums = {35, 21, 5, 6, 55, 7, 42, 165};
    boolean[] removed = new boolean[nums.length];

    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] > nums[j] && nums[i] % nums[j] == 0) {
                removed[j] = true;
            } else if (nums[i] < nums[j] && nums[j] % nums[i] == 0) {
                removed[i] = true;
            }
        }
    }

    for (int i = 0; i < nums.length; ++i) {
        if (!removed[i]) {
            System.out.print(nums[i] + " ");
        }
    }

    System.out.println();