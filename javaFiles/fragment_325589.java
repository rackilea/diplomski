for (int i = 3;i <= n;i++) {
    //calculate the new fibanacci, will get the fibonacci #1 variable
    f = f1 + f2;

    //the next fibonacci #2 will be the same as fibonacci #3 was before
    f1 = f2;

    //set the new fibonacci to fibonacci #3
    f2 = f; 
}