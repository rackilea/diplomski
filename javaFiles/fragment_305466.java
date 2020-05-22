class SimpleJob implements Runnable {
int i;
public void run(){

    synchronized (this) {
        for(i=0; i<8; i++){
            System.out.println(Thread.currentThread().getName()+" Running ");
        } 
    } 

    try {
        System.out.println("Here");
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    for(i=0; i<2; i++){
        System.out.println(Thread.currentThread().getName()+" Running ");
    }
}

public int getCount(){
    return i;
}
}

public class Threadings {
public static void main(String [] args){
    SimpleJob sj = new SimpleJob();
    Thread t1 = new Thread(sj);
    Thread t2 = new Thread(sj);

    t1.setName("T1");
    t2.setName("T2");

    t1.start();
    t2.start();
}    
}