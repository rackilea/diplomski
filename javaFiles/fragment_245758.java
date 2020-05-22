int count=0;
for(int i=0; i < nums.length-1; i++){
    if(nums[i] == 3 && nums[i+1] == 3) {
        return false;
    }
}
for(int i=0; i < nums.length; i++){
    if(nums[i]==3)
        count++;
}
return (count == 3);