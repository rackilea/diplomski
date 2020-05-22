private static <AnyType extends Comparable<? super AnyType>> void   
    quicksort(AnyType [] a, int left, int right)
    {
        final int CUTOFF = 3;
        if (left + CUTOFF <= right) 
        { 
            AnyType pivot = (AnyType) median3 (a, left, right);
            int i = left - 1, j = right + 1;    // fix
            for( ; ;)
            {
                while( a[++i].compareTo(pivot) < 0) {}
                while( a[--j].compareTo(pivot) > 0) {} // fix
                if(i < j)
                    swap(a, i, j);
                else
                    break;
            }
        //  swap(a, i, right - 1);              // delete
            quicksort(a, left, j);              // fix
            quicksort(a, j + 1, right);         // fix
        } 
          else
            insertionSort(a, left, right);
    } 

    private static <AnyType extends Comparable<? super AnyType>> AnyType 
    median3(AnyType [] a, int left, int right)
    {
        int center = (left + right) /2;
        if (a[center].compareTo(a[left]) < 0)
            swap(a,left,center);
        if (a[right].compareTo(a[left]) < 0)
            swap(a, left, right);
        if (a[right].compareTo(a[center]) < 0)
            swap(a, center, right);
    //  swap(a, center, right - 1);             // delete
        return a[center];                       // fix
    }