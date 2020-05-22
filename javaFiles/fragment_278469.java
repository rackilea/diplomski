Thread t1 = new Thread(new Quicksort_Parallel(0, array_parallel.length-1, array_parallel));

        sp_parallel.setStart(System.currentTimeMillis());
        t1.start();

        try {
            t1.join();