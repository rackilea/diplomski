public static void main(String args[]){  
    Table obj = new Table();//only one object  
    Thread thread1 = new Thread(new t1(obj));  // t1 is the Runnable class
    MyThread2 thread2 = new MyThread2(obj);  
    thread1.start();
    thread2.start();  
}