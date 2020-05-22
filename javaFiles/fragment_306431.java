if (line.length() > 0) {
    String[] lineArray = line.split("\\s");
    double[] nums = new double[lineArray.length];
    if (lineArray.length > 0) {
        for (int i = 0; i < lineArray.length; i++) {
            if (!lineArray[i].isEmpty()) {
                nums[i] = Double.parseDouble(lineArray[i]);
            }
        }
        Arrays.sort(nums);
    }
    for (int i = 0; i < nums.length - 1; i++) {
        System.out.print(nums[i] + " ");
    }
    System.out.print(nums[nums.length - 1]);
    System.out.print("\n");
}