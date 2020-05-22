int i = 0;    
while (!StdIn.isEmpty()) {
    i++;
    // read in the next integer
    int t = StdIn.readInt();


    if ( i > a && i <= a + b) {
        StdOut.print(t + " ");
    }
}