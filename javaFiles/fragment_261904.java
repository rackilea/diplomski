private static final int NTHREDS = 255;


    //.......
        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        List<Future<Boolean>> thread_Values_list = new ArrayList<>();
        for (int i = 1; i <= 255; i++) {
            final int j = i;
            try {
                try {
                    String testIp = prefix + String.valueOf(j);
                    RunnableTask worker = new RunnableTask(testIp);
                    Future<Boolean> submit = executor.submit(worker);
                    thread_Values_list.add(submit);

                } catch (Exception e) {
                    e.printStackTrace();
                }


            } catch (Exception e) {


            }
        }
        for (Future<Boolean> finishedThread : thread_Values_list) {

            String reachable_Ip = "";
            try {
                if (finishedThread.get()) {
                    reachable_Ip = prefix + String.valueOf(finishThread_counter);
                    ipList.add(reachable_Ip);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            finishThread_counter++;
        }

        executor.shutdown();
    }