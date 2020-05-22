class BubbleSort{
    public static void main(String args[]){

        int nums [] = {5, 4, 6, 3, 12, 1};

        Boolean swap = true;
        while(swap){
            swap = false;
            for(int i = 1; i<nums.length ; i++){
                if (nums[i - 1] > nums[i]){
                    int t = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = t;
                    swap = true;
                }/* else{
                    swap = false;
                }*/
            }
        }

        System.out.print("Sorted: ");
        for(int j=0 ; j<nums.length ; j++)
            System.out.print(nums[j] + " ");
    }
}