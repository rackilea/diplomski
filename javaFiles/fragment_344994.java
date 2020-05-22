public int insert(int x)  {
    if(numElements == elements.length) {
         int[] enlargedElements = new int[elements.length * 2];
         System.arraycopy(elements, 0, enlargedElements, 0, elements.length);
         elements = enlargedElements;
    }   
    int pos = binarySearch(x);
    if(pos == -1) 
        return -1;
    if(pos < numElements) {
        System.arraycopy(elements, pos, elements, pos + 1, numElements - pos);
    }
    elements[pos] = x;
    numElements++;
    return pos;
}

private int binarySearch(int x) {
    int inf = 0;
    int sup = numElements - 1;
    if(sup == -1 || elements[0] > x)
        return 0;
    if(elements[sup] < x)
        return numElements;
    //Invariante di ciclo: se x in a, allora x in a[inf...sup]
    while(inf <= sup) {
        int i = (inf  + sup) >>> 1; //divide per due
        if(elements[i] > x)
            sup = i - 1;
        else if(elements[i] < x)
            inf = i + 1;
        else
            return -1;
    }
    return inf;
}