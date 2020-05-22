public int zeroCount(int[] a) {

    if (a[0] == 1)    // all are 1
        return 0;
    int length = a.length;
    if (a[length - 1] == 0)   //all are 0
        return length;

    return count(a, 0, length);
}

public int count(int[] a, int lower, int upper) {
    int mid = (lower + upper) / 2;
    if (a[mid] != a[mid - 1])   
        return mid;

    if (a[mid] != a[mid + 1])    
        return mid + 1;

    if (a[mid] == 1) {                // all are 1 above mid 
        return count(a, lower, mid - 1);  
    } else if (a[mid] == 0) {              // all are 0 below mid 
        return count(a, mid + 1, upper);  
    }
    return 0;
}