boolean seenSix = false;
for(int i=0;i<nums.length;i++){
    if (!seenSix) {
        if(nums[i] != 6) {
            sum[i] += n[i];
        } else {
            seenSix = true;
        }
    } else {
        seenSix = (n[i] != 7);
    }
}