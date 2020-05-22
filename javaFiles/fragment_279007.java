public static int posOfSmallestElementGtOeT( double limit, double[] list) {
    double greater = 0;
    int pos = -1;
    for(int i=0; i < list.length; i++) {
        if(list[i] >= limit) {
            if(pos == -1) // check whether its the first value above the limit in the list
                pos = i;
            else if(list[pos] > list[i]) //compare the current value with the previous smallest value
                pos = i;
        }
    }
    return pos;
}