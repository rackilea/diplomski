import java.util.*;

public class Runner extends Thread {
    Date startDate;
    long startTime;    
    String name;
    private boolean flag = true;

    //This method will set flag as false
    Runner(String name)
    {
        this.name = name;
    }

    public synchronized void stopRunning()
    {
        flag = false;
        notifyAll(); //Think about if you really need the All
    }

    @Override
    public synchronized void run()
    {
        this.startDate = new Date();
        this.startTime = this.startDate.getTime();
        System.out.println(startTime);         
        while (flag) {
            try { //Just for the sake of compiling - you may think of a better solution
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace(); 
            }
        }
        Date d = new Date();
        System.out.println(this.name + " Stopped Running....");
        System.out.println("The time that passed is " + Long.toString((d.getTime()-this.startTime)/1000) + " secondes" );
    }
}