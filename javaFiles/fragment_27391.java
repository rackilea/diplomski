String result1 = null;

String result2 = null;

public void test() {
    Thread thread1 = new Thread(new Runnable(){
        public void run(){
            result1 = doSomething();
        }
    });
    Thread thread2 = new Thread(new Runnable(){
        public void run(){
            result2 = doSomething2();
        }
    });
    thread1.start(); 
    thread2.start();
    thread1.join(); 
    thread2.join();
    ...
    ...

}