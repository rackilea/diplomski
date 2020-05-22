public static Integer solveProblem(int n) {
    if (n==0) 
        return 0;
    else if (n==1) 
        return 2;
    else if (n>=0 || n<100000) {
        int fibo[] = new int[n+1];
        fibo[0] = 0; fibo[1] = 1;
        int sum = fibo[0] + fibo[1];
        for (int i=2; i<=n; i++) {
            fibo[i] = fibo[i-1]+fibo[i-2];
            if(n >= fibo[i]) {
                sum += fibo[i];
            } else {
                break;
            }
        }
        return sum;
    } else {
        return 0;    
    }
}