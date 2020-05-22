public static void main (String[] args) throws java.lang.Exception {
        for (int i = 0; i < 10; i++) {  
            new Thread1().start();  
        }  
}

//no need for this to be an instance method, or internally synchronized
public static int getNum(int i) {  
       return i + 1;  
}

static class Thread1 extends Thread {  
    static Integer value = 0;  

    @Override  
    public void run() {  
        while (value < 100) {
            synchronized(Thread1.class) {  //this ensures that all the threads use the same lock
                value = getNum(value);  
                System.out.println("Thread-" + this.getId() + ":  " + value);  
            }

            //for the sake of illustration, we sleep to ensure some other thread goes next
            try {Thread.sleep(100);} catch (Exception ignored) {} 
        }
    }  
}