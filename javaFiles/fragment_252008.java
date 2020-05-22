public class Main {
    public static void main(String[] args) {
        InfiniteThread t = new InfiniteThread();
        t.start();
        for(int i=0;i<10;i++) {
            t.fromOut(i);
        }
    }
    @DebugLog
    public static class InfiniteThread extends Thread {

        public void run() {
            for(int i=0;i<10;i++) {
                fromIn();
            }
        }

        private void fromIn() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void fromOut(Object data){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}