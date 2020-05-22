public static void printFirstHalf(int m, int n){
    if(m>n){
        return;
    }

    // print asterix
    for(int i=1; i<=m; i++){
        System.out.print("*");
    }
    System.out.println();

    // recurse
    printFirstHalf(m+1,n);
}