public void insertionSort() {
        int out, in ;
        for (out = 1; out < nItems; out++) {
            int temp = list[out]; in = out; // -- temp should be int, since your list is an array of int. and your array is called list, not arr
            while ( in > 0 && list[ in -1] >= temp) {
                list[ in ] = list[ in -1];
                --in ;
            }
            list[ in ] = temp;
        }
    }