// This will contain the running times of the different sorting functions
long[] elapsed = new long[12];
// This will contain the names of the sorting functions
String[] names = new String[12];

long before, after; // used to compute the running times

// Time merge sort
before = System.nanoTime();
iterativeMergeSort(copy12);
after = System.nanoTime();
elapsed[0] = after-before;
names[0] = "Merge sort";

// Time insertion sort
before = System.nanoTime();
insertSort(copy9);
after = System.nanoTime();
elapsed[1] = after-before;
names[1] = "Insertion sort";

// ... Do the same for the others ...

// Determine the smallest running time
int fastest = 0;
for(int i=1; i<12; i++) {
    if(elapsed[i]<elapsed[fastest])
        fastest = i;
}
// Now the variable fastest contains the index of the fastest function
System.out.println("The fastest function was " + names[fastest] + ", with a running time of " + elapsed[fastest] + " nanoseconds.");