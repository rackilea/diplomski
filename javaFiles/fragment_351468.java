import java.util.ArrayList;
import java.util.List;

public class MultiThreaded {

    private static class ListAppender implements Runnable {

        private List<String> strings;
        private String string;

        public ListAppender(List<String> strings, String string) {
            this.strings = strings;
            this.string = string;
        }

        @Override
        public void run() {
            strings.add(string);
        }
    }

    private static class ListConsumer implements Runnable {

        private List<String> strings;

        public ListConsumer(List<String> strings) {
            this.strings = strings;
        }

        @Override
        public void run() {
            for (String s : strings) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        List<String> strings = new ArrayList<String>();

        Thread helloThread = new Thread(new ListAppender(strings, "Hello"));
        helloThread.start();
        Thread worldThread = new Thread(new ListAppender(strings, "world!"));
        worldThread.start();

        Thread.sleep(1000);

        new Thread(new ListConsumer(strings)).start();
    }
}