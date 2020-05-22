public static void main(String args[]){
    System.out.println(palindrome(133));
}

private static int palindrome (int n){
     return palindrome(n,n);
}

private static int palindrome( int n, int r ){
    if(r==0)
        return n;
    return palindrome(n*10+r%10,r/10);
}