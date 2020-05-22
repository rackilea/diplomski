Thread[] workers = new Thread[count];
    for (int i = 0; i < count; i++) {
        final int index = i;
        //create thread to calculate i-th value
        workers[i] = new Thread(new Runnable() {
            @Override
            public void run() {
                results[index] = complexCalculationsAndSearcOnHashMap(data[index]);
            }
        });
        workers[i].start();
    }
    for (int i = 0; i < count; i++) {
        //wait until threads execution is finished
        workers[i].join();
    }

    //Test output
    System.out.println(Arrays.toString(results));