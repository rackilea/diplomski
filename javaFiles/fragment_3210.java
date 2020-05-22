int[] numbers = new int[nums.length];
for(int i = 0;i < nums.length;i++){
   numbers[i] = Integer.parseInt(nums[i]);
}
BasicFunc obj = new BasicFunc();
int result = obj.sum(numbers);