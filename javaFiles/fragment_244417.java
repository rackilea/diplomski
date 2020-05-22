//Assume arr, nElems are declared somewhere else and enough space to insert...
public void insert(long value) {
    int lowerBound = 0;
    int upperBound = nElems;
    int curIn;
    while(lowerBound < upperBound) {
        curIn = (lowerBound+upperBpund)/2;
        if(arr[curIn] > value) {
            upperBound = curIn;
        } else {
            lowerBound = curIn+1;
        }
    }
    //note lowerBound may equal nElems, it works anyway
    for(int k = nElems; k > lowerBound; k--) {
        arr[k] = arr[k-1];
    }
    arr[lowerBound] = value;
    nElems++;
}