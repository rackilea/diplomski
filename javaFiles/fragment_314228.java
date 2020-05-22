public static class CVResult {      
    public double param1;
    public double param2;
    public double accuracy;
}

public static class WorkerThread implements Runnable {

    private double param1;
    private double param2;
    private double accuracy;

    public WorkerThread(double param1, double param2){   
        this.param1 = param1;
        this.param2 = param2;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                " [parameter1] " + param1 + " [parameter2]: " + param2);
        processCommand();
    }

    private void processCommand() {
        try {

            Thread.sleep(500);
            ;
            /*
             * ### PERFORM YOUR CROSSVALIDATION ALGORITHM HERE ###
             */

            this.accuracy = this.param1 + this.param2;

            // Give back result:

            CVResult result = new CVResult();

            result.accuracy = this.accuracy;
            result.param1 = this.param1;
            result.param2 = this.param2;

            Main.addResult(result);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}