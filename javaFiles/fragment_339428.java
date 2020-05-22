ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
service.scheduleAtFixedRate(new Runnable() {
    @Override
    public void run() {
        readLog(); // method to read log file
        sortByDate(); //sort punch in data by day
        checkPeopleIn(); // check people who are in, add and remove to list accordingly
        output_details(); //output final details
        System.out.print("_____________________________________");
    }
}, 0, 1, TimeUnit.HOURS);
service.shutdown();