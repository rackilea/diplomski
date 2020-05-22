private static int count = 0;

private static int chain(int n) {
    count++;

    while(n > 1) {
        if(n % 2 == 0) {
            return chain(n/2);
        }

        return chain(3*n+1);
    }

return count;
}