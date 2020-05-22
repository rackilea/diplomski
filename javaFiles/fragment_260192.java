public class StairCase {
    public static void main(String[] args) {
        int[] lst = {1,2,3,4,5,6,7};
        Test1 t1 = new Test1(lst);
        t1.setName("Test 1 ");
        Test2 t2 = new Test2(lst);
        t2.setName("Test 2 ");
        t1.start();
        t2.start();
    }
}

class Test1 extends Thread {
    private final int[] line ;
    Test1(int[] lst) {
        this.line = lst;
    }
    public void run(){
        synchronized(line) {
            for (int i = 0; i < 5; i++) {
                try{
                    if(i == 2) line.wait();
                } catch (Exception e) {
                  e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + line[i]);
            }
        }
    }

}

class Test2 extends Thread {
    private final int[] line ;
    Test2(int[] lst) {
        this.line = lst;
    }
    public void run() {
        synchronized(line) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + line[i]);
            }
        }
        try {
            synchronized (line) {
                line.notify();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}