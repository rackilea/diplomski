int a(n) {
 if (n==1) 
    return 1
 else  //optional
    return a(n-1) / 2
 }