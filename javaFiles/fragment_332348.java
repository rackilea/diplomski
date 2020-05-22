public boolean split53Helper(int start, int [] nums, int group3, int group5){
  if(start >= nums.length){
    return group3 == group5;
  }

  if(nums[start] % 3 == 0 ){
    if (split53Helper(start + 1, nums, group3 + nums[start], group5)){
      return true;
    } else {
      return false; // <-------
    }
  }

  if(nums[start] % 5 == 0){
    if (split53Helper(start + 1, nums, group3, group5 + nums[start])){
      return true;
    } else {
      return false; // <-------
    }
  }

  if(split53Helper(start+1, nums, group3 + nums[start], group5))
      return true;

  if(split53Helper(start+1, nums, group3, group5 + nums[start]))
      return true;

  return false;
}