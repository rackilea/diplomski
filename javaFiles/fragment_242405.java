public class Tester {
    static void testProgress(int all, int now) {
        final int MAX_PIPE_CHAR = 10;
        float num = now * MAX_PIPE_CHAR * 1.01f; // 1.01f to account for any round off
        int current = (int) (num / all);
        int rest = MAX_PIPE_CHAR - current;

        System.out.print("\r[");
        for (int a = 1; a <= current; a++) {
            System.out.print("|");
        }
        for (int b = 1; b <= rest; b++) {
            System.out.print(" ");
        }
        System.out.print("]");

    }

    public static void main (String args[]){
        for (int i = 0; i <= 100; i++) { // to test, taken from Aleksandar (slight modification)
            testProgress(100, i);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}