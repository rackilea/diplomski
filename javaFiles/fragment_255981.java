public static int findMaxConsecutiveOnes(int[] nums) {      

     int i=0, j=0, maxLen=0;

     while(j<nums.length) {

         if(nums[j] == 1) {

            i=j;
            while (j + 1 < nums.length && nums[j + 1] == 1) {
                j++;
            }

            if( j - i + 1 > maxLen) {
                maxLen = j - i + 1;
            }
         }

         j++;        
     }

     return maxLen;

}