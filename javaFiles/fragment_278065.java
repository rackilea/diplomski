int firstPointer = 0;
    int secondPointer = nums.length - 1;
    int[] newarray = new int[nums.length];
    int i = 0;
    for (i = 0; i < nums.length-1; i += 2) {
        newarray[i] = nums[firstPointer++];
        newarray[i+1] = nums[secondPointer--];
    }
    if(i<nums.length-1)
        newarray[i] = nums[firstPointer++];