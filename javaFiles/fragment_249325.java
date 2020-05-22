public static int[] maxsub(int array[], int low, int high){
    int[] maxSubLeft = new int[3];
    int[] maxSubRight = new int[3];
    int[] maxSub = new int[3];
    int[] maxSubCross = new int[3];
    int mid;
    if (high==low){
        maxSub[0] = low;
        maxSub[1] = high;
        maxSub[2] = array[low];
        return maxSub; // if (array[low] < 0) return 0;
    }
    else{
        mid = (int) Math.floor((low+high)/2);
        maxSubLeft = maxsub(array,low,mid);
        maxSubRight = maxsub(array,mid+1,high);
        maxSubCross = maxcross(array,low,mid,high);

        if(maxSubLeft[2] >= maxSubRight[2] && maxSubLeft[2] >= maxSubCross[2])
            return maxSubLeft;
        else if(maxSubRight[2] >= maxSubLeft[2] && maxSubRight[2] >= maxSubCross[2])
            return maxSubRight;
        else
            return maxSubCross;
    }
}