Scanner sc = new Scanner(System.in);
    int[] nums = new int[51]; //Array size is 51 since it should hold numbers from 0 to 50 inclusive.
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