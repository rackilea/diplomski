//ask user for array size
int n = getInt();
//create array for n integers
int[] array = new int[n];
//read n integers from user
for (i in 0..n-1)
    tmp = readInt()
    //and store them in array
    put tmp in array at position i

//print content of array backwards
for (i in n-1..0)
    print(i-th element from array)