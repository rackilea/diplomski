// Time merge sort
long beforeMerge = System.nanoTime();
iterativeMergeSort(copy12);
long afterMerge = System.nanoTime();
long elapsedMerge = afterMerge - beforeMerge;

// Time insertion sort
long beforeInsert = System.nanoTime();
insertSort(copy9);
long afterInsert = System.nanoTime();
long elapsedInsert = afterInsert - beforeInsert;

// Print the elapsed time for each
System.out.println("Merge sort elapsed time = " + elapsedMerge + "ns.");
System.out.println("Insertion sort elapsed time = " + elapsedInsert + "ns.");
if(elapsedMerge<elapsedInsert)
    System.out.println("Merge sort was faster");
else
    System.out.println("Insertion sort was faster");