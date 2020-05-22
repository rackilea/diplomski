public class VisitPage {
    public void start(Task<Void> task, String URL) {
        while (!task.isCancelled()) {
            System.out.println("Running test");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Test run ended");
        }
        System.out.println("Canceling...");
        System.out.println("Stop Pressed");
        return;
    }
}