for(int a=0; a<=k/3; a++) { // a <= b <= c -> 3a <= k
    for(int b=a; b<=(k-a)/2; b++) { // b <= c -> 2b <= k-a
        c = k-a-b;
        //Do your thing
    }
}