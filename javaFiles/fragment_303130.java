unsigned int nonZeroCount = 0;

// Count the amount of non-zero values
for (int i = 0; i < frame.length; i++){
    if (frame[i]!=0)
        nonZeroCount++;
}

// Create the NEW Array
final int[] sorted = new int[nonZeroCount];

// NEXT add them to your new array, Need to have 2 separate counters, 1 for your initial array,
// Another for where you are placing it within your new array
unsigned int anotherCount = 0;
for (int i = 0; i < frame.length; i++){
    if (frame[i]!=0){
        sorted[anotherCount ] = frame[i];
        anotherCount++;
    }
}