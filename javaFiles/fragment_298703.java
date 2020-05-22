public int[] twoSum(int[] nums, int target) {

    for(int i=nums[0];i<nums.length;i++){
           for(int x:nums){
               if (x!=i & (i+x)==target){
                  int i2 = java.util.Arrays.asList(nums).indexOf(i);
                  int x2 = java.util.Arrays.asList(nums).indexOf(x);
                  int[] answer = {i2,x2};

                  return answer;

               }else{
                   return nums;
               }


           }

       }

       return nums; //or whatever you want (maybe null, or an empty array)
  }