public class MyJob implements Runnable {
    // you can construct your jobs and pass in context for them if necessary
    public MyJob(String someContext) {
        ...
    }
    public void run() {
        // process the small job
    }
}