public int[] post4(int[] nums) {

    int[] result = new int[0];

    int j = 0;
    for (int i = 0; i<nums.length; i++){
       if (nums[i] == 4) {
           result = new int[nums.length - i-1];
           j=0;
       }
       else 
           if (result.length>0) result[j++] = nums[i]; 
    }

    return result;
}