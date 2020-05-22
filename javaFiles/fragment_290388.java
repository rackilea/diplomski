int[] nums = new int[2];

for (int i = 0; i < 100; i++) {
    nums[i % nums.length] = i + 1;

    if (nums[0] + nums[1] <= 50) {
        System.out.println("sum is less than or equal to 50");
        break;
    }
}