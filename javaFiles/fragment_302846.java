int[] nums = {0,1,2,3,4,5,6,7,8,9};

//Shuffle array
for(int x=0; x<nums.length; x++){
    int i = (int)(Math.random()*10);  //generate random 0-9
    int temp = nums[x];
    nums[x] = nums[i];
    nums[i] = temp;
}