public static int printSum(int n) {
        int sum = 0;
        for(int x = 0; x < n; x++){
            sum += n - x;
            if(x != n - 1){
                System.out.print((n - x) + "+");
            }
            else{
                System.out.print((n - x) + "=" + sum);
            }
        }
        return sum;
    }