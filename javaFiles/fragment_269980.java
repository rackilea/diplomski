UnSafeSequence unsafe = new UnSafeSequence();
 ...
 new Thread(new MyThread(unsafe)).start();
 new Thread(new MyThread(unsafe)).start();
 ...
 class MyThread implemented Runnable {
       private UnSafeSequence unsafe;
       public MyThread(UnSafeSequence unsafe) {
            this.unsafe = unsafe;
       }
       public void run() {
            ...
            unsafe.getNext();
            ...
       }
 }