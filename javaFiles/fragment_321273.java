public static void main(String[] args) {
    int nums [] = new int[]{2, 4, 8};
    int target = 10;
    int nums_another [] = grouped (nums);
    System.out.println(viable(0, nums_another, 0, target));
}

private static int [] grouped (int nums []) {
    int nums_another[] = new int [nums.length];
    int i = 0;
    int j = 0;
    i++;
    int c = 1;
    while (i < nums.length){
        if (nums[i] == nums[i-1]) { // count identical numbers
            c++;
        }
        else { // not identical, store sum of previous identical numbers (possibly only 1 number)
            if (nums[i-1] != 0) {
                nums_another[j] = nums[i-1] * c;
                j++;
            }
            c = 1;
        }
        i++;
    }
    if (nums[i-1] != 0) { // store last
        nums_another [j] = nums[i-1] * c; 
    }
    return nums_another;
}

/* partial_sum + sub array of "array from start to 0's" -> target */
private static boolean viable (int partial_sum, int array[], int start, int target) {
    if (partial_sum == target) {
        return true;
    }
    else if (start >= array.length || array[start] == 0) {
        return false;
    }
    else { // Key step
        return viable (partial_sum + array[start], array, start + 1, target)
            || viable (partial_sum,                array, start + 1, target);
    }
}