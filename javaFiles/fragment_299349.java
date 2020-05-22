double[][] d = { {1,2}, {3,4}, {5,6} };
// create the vector of (still missing) rows:
double[][] copy = new double[d.length][];
for( int row = 0; row < d.length; ++row ){
    // create another row of appropriate length:
    copy[row] = new double[d[row].length];
    // copy the element values
    System.arraycopy( d[row], 0, copy[row], 0, d[row].length );
}