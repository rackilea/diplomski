int k = 1;
long sum = 0;
while(k<=n-1){
    long pow = 1;
    for (int i = 0; i < n - 1; i++)
        pow = (pow * k) % n;
    sum = (sum + pow)%n;
    k++;
}