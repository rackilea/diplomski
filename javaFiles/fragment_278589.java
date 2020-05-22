public static void mergeSort(ArrayList <Comparable> a, int first, int last){
        if(first < last){
            int mid = first + (last - first) /2;
        //    System.out.println("mergeSorting " + a.subList(first, mid ));
            System.out.println("First"+first);
            System.out.println("Mid"+mid);
            System.out.println("Last"+last);
            System.out.println("MergeSortCall");
            System.out.println("firstVector " + a.subList(first, mid+1));
            System.out.println("secondVector " + a.subList(mid + 1,last+1));                
            mergeSort(a, first, mid);
            mergeSort(a, mid + 1, last);
            merge(a, first, mid, last);
            System.out.println("mergeVector " + a.subList(first,last+1));
        }

    }