public class StateThread extends Thread{
   String state = "ThreadState";
   public synchronized void setState(String newState){
      state = newState;
   }
   public synchronized String getState(){
      return state;
   }
   @override
   public void run(){
      // Do stuff and update state...
   }
}