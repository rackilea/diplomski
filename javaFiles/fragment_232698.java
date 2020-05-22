int[][] nums = {{16, 29, 31, 65, 67}, {28, 30, 39, 59, 70}, {1, 42, 47, 64, 70}};

for (int row = 0; row < nums.length; row++) {
    int sum = 0;
    for (int col = 0; col < nums[row].length; col++)
        sum += nums[row][col];
    System.out.println(Arrays.toString(nums[row]));
    System.out.println(sum);
}