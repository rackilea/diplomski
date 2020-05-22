class MyClass implements Runnable{
    public void run() {
            System.out.println(this);
            System.out.println("Starting Implementation of "+Thread.currentThread().getName());
            synchronized(this){
                for(int i=1;i<=10;i++){
                    System.out.println("Class  :"+Thread.currentThread().getName()+" "+i);
                }
            }
            System.out.println("Ending Implementation of "+Thread.currentThread().getName());
    }
}


public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Program starts..");

        MyClass obj = new MyClass();
        Thread th1 = new Thread(obj);
        Thread th2 = new Thread(obj);
        th1.setName("Athread");
        th2.setName("BThread");
        th1.start();
        th2.start();

        System.out.println("Program ends...");
    }
}