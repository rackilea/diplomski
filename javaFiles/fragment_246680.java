for ( int i = 0; i < num.length - 1; i ++ ) {
    int numI;
    try { numI = Integer.parse(num[i]); } catch (NumberFormatException nfe) { continue; }
    for (int j = i + 1; j < num.length; j ++ ) 
        int numJ;
        try { numJ = Integer.parse(num[i]); } catch (NumberFormatException nfe) { continue; }
        if (numI < numJ) {
            String temp = num[ i ];   //swapping
            num[ i ] = num[ j ];
            num[ j ] = temp;
        }
    }
}