package test2;

import java.util.concurrent.Semaphore;

public class mainclass {

    static Thread1 t;

    static Semaphore sem;

    static Semaphore sem_protect;

    public synchronized static void main (String[] args) {

         sem = new Semaphore(0);

         sem_protect = new Semaphore(1);

         t =  new Thread1();

         Thread1 th1 = new Thread1();
         th1.start();

         Thread2 th2 = new Thread2();
         th2.start();

         try {
             synchronized (th2){
            th2.wait();
             }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

         System.out.println("The end !");
      }


    public static class Thread1 extends Thread { 

        private int num;

        public void run() {

            try {
                sem.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } // here it blocks waiting for another thread 
                           //to call its setInt function and release it
            try {
                sem_protect.acquire();
                System.out.println("num is " + num);
                sem_protect.release();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }

        public synchronized void setInt(int i) {

            try {
                sem_protect.acquire();
                this.num = i;
                sem_protect.release();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            System.out.println("value of num is: "+num);
        }
    }

    public static class Thread2 extends Thread {
        public void run() {
            t.setInt(5);
            sem.release();
        }
    }

}