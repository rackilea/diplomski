int[] nums = new int[3];
for (int i = 0; i < nums.length; i++) {
    nums[i] = JOptionPane.showInputDialog(null, "Enter integer " + i, 
                    "Exercise3_8", JOptionPane.QUESTION_MESSAGE);
}
Arrays.sort(nums);
for (int i = 0; i < nums.length; i++) {
    System.out.println(nums[i]);
}