public void run()
    {
        long store = System.currentTimeMillis();
        if(sortingAlgorithm.equals(sorter.MERGE_SORT_TEXT))
        {
            MergeSort.mergeSort(arr);
        }
        if(sortingAlgorithm.equals(sorter.SELECTION_SORT_TEXT))
        {
            SelectionSort.sort(arr);
        }
        if(sortingAlgorithm.equals(sorter.INSERTION_SORT_TEXT))
        {
            InsertionSort.sort(arr);
        }
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                sorter.displayResult(arr.length, System.currentTimeMillis()-store);
            //call Sorter's displayResult method here
            }
        });
    }