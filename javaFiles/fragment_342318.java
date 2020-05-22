void quicksort(int arr[], int lb, int ub){
     if ((ub-lb) < 100){             // < 32 may be fastest
        System.out.println("Large");
        insertionSort(arr, lb, ub);
        return;
     }
     int index = partition(arr, lb, ub);
     if (lb < index-1)
        quicksort(arr, lb, index-1);
     if (index < ub)
        quicksort(arr, index, ub);
  }

  public static void insertionSort(int x[], int lb, int ub){
     int h, k, y;
     for (h = lb+1; h <= ub; h++){
        y = x[h];
        for (k = h; k > lb && x[k-1] > y; k--)
           x[k] = x[k-1];
        x[k] = y;
     }
  }