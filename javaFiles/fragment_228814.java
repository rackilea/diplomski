public static long sum(long x){ 
long sum = 1;
int sqrt = (int)Math.sqrt(x);

for (int i = 2; i <= sqrt; i++) {
    if (x % i == 0) {
        sum += i + (x/i);
    }
}
//checks if perfect square and subtracts out extra square root.
if(sqrt * sqrt == x) sum -= sqrt;  

return sum;
}