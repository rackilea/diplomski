public static void main(String[] args) {

        int[] nums = new int[] {34, 53, 125, 854, 8, 1045, 66, 9434, 5205, 235};

        int e = 0, o = 0;

        for(int i = 0; i < nums.length; i++)
        {
            int remainder = nums[i] % 2;

            switch(remainder){
                case 0:
                    e++;
                    break;
                case 1:
                    o++;
                    break;
                default:
                    break;
            }
        }
        System.out.println("There are " + e + " even numbers. There are " + o + " odd numbers.");
    }