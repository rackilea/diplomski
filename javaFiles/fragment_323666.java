public class BootStrap extends Runnable{

    public static void main(String[] args){
        new RealtimeThread(new BootStrap()).start();
        //main finishes running and stops
    }

    public void run(){
    //...
    }
}