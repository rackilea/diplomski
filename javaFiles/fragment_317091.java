class Test {
    private int count = 0;
    public void incrementCount() {
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
        Test t = new Test();
        for ( int i=0; i<10; i++){
            new Thread(new MyRunnable(t)).start();  
        }
    }
}