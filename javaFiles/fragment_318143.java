void gcd(int a, int b){
     if(b == 0)
        return;
     print a/b squares with size b x b;
     gcd(b, a % b);
}