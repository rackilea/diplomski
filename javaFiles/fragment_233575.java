static int part(int low, int high, int [] S) {
    int i;
    int j;
    int randspot;
    int pivotitem;
    int pivotpoint;
    Random random = new Random(456);
    randspot = random.nextInt(high-low +1)+low;
    System.out.println( " p = " + randspot );
    System.out.println( " value = " + S[randspot] );
    pivotitem = S[randspot];
    //---------------Start code block
    int temp1 = S[randspot];
    S[randspot] = S[low];
    S[low] = temp1;
    //---------------End code block
    j = low;
    for (i = low + 1; i <= high; i++)
        if (S[i] < pivotitem){
            j++;
            int temp = S[j];
            S[j] = S[i]; //exchanges S[i] and S[j]
            S[i] = temp;
        }
    pivotpoint = j;
    int temp = S[low];
    S[low] = S[pivotpoint];
    S[pivotpoint] = temp;
    return pivotpoint;
}