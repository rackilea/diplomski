class Test {
    private static int count = 0;
    public static void incrementCount() {
        count++;
        System.out.println("Count:"+count);
    }
} 
class MyRunnable implements Runnable{
    private Test test = null;
    public MyRunnable(Test t){
        this.test = t; 
    }
    public void run(){
        test.incrementCount();
    }
}
public class SynchronizedDemo{
    public static void main(String args[]){
        for ( int i=0; i<10; i++){
            Test t = new Test();
            new Thread(new MyRunnable(t)).start();  
        }
    }
}