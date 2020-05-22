import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        ExampleWorker worker = new ExampleWorker();
        worker.execute();
        Thread.sleep(100);
        try {
            System.out.println(">> " + worker.get());
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }
    }

    public static class ExampleWorker extends SwingWorker<String, Integer> {

        private int n = 0;
        private long startTime;

        @Override
        protected String doInBackground() throws Exception {
            System.out.println("doInBackground()");
            startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 3000) {
                publish(n++);
                Thread.yield();
            }
            return "What is this used for?";
        }

        @Override
        protected void process(List<Integer> chunks) {
            for (int value : chunks) {
                System.out.println(value);
            }
        }

        @Override
        protected void done() {
            System.out.println("Done: " + n);
        }

    }

}