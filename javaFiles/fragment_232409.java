public MyThread extends Thread {

    public void run() {
        try {
            runLongTask1();
            runLongTask2();
        }
        catch (Exception e) {
            return;
        }
    }

    public void runLongTask1() throws Exception {
        // your code here
    }

    public void runLongTask2() throws Exception {
        // your code here
    }
}