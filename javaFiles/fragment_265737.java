public void recursiveFunc(int n) {
    if (n <= 0) 
       return;
    recursiveFunc(n-1); 
    System.out.println(n); 
}