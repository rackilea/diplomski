public int getSum(int n, int m){
    return (m*(m+1)/2) - ((n-1)*((n-1)+1)/2)
}

F(n) = (n*(n+1)/2) = 0+1+2+...+n
F(m) - F(n-1) = n + n+1 + n+2 + ... + m