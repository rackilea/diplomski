public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[51];
        int[]occur = new int[51];


        for(;;){
            int n = sc.nextInt();
            if(n > 50){
                continue;
            }
            if(n == -1){
                break;
            }
            occur[n] += 1;
            nums[n] = n;
        }

        System.out.println("All Numbers entered:");
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.out.println("All Occurrences: ");
        for(int i = 0; i < occur.length; i++){
            System.out.print(occur[i] + " ");
        }
        sc.close();
    }