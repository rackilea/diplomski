public int uniques(int[] a) {
    int tempArray[] = new int[a.length];
    boolean duplicate = false;
    int index = 0;
    int digitsAdded = 0;

    for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < tempArray.length; j++) {
            if (a[i] == tempArray[j]) {
                duplicate = true;
            }
        }
        if(!duplicate) {
            tempArray[index] = a[i];
            index++;
            digitsAdded++;
        }
        duplicate = false;
    }
    //this loop is needed if you have '0' in your input array - when creating temp 
    //array it is filled with 0s and then any 0 in input is treated as a duplicate
    //again - not most elegant solution, maybe I will find better later...
    for(int i = 0; i < a.length; i++) {
        if(a[i] == 0) {
            digitsAdded++;
            break;
        }
    }
    return digitsAdded;
}