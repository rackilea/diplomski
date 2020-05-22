public class Square(){

...


public void arriveOnSquare(){
    notify();
    ...
    synchronized(this){
        wait();
    }
    ...
}
}