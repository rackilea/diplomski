public static void main(String[] args) {
    int[] nums = {15,31,7,2,7};
    int[] place = new int [nums.length];
    int[] definer = new int [nums.length];
    int a = 0,b = 0,c;
    place[0] = a;
    place[1] = 1;
    for (int i1 = 0; i1<place.length; i1++) {
    for (int i = 0; i<nums.length; i++) {
        if (nums[i] > a) {
            place[i1]=nums[i];
            a=place[i1];
            definer[i]=1;