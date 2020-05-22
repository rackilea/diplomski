public static void main(String[] args) {

    int[] nums = {15,31,7,2,7};
    int[] place = new int [nums.length];
    int[] definer = new int [nums.length];

    int a = 0,
    int b = 0;

    place[0] = a;
    place[1] = 1;

    for (int i = 0; i < place.length; i++) {

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] > a) {

                //first a = 0 just so i remember
                //int[] nums = {15,31,7,2,7};

                place[i] = nums[j];
                a = place[i];
                definer[j] = 1;