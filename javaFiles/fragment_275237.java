public class InterruptableUDPThread extends Thread{

   private final DatagramSocket socket;

   public InterruptableUDPThread(DatagramSocket socket){
      this.socket = socket;
   }
   @Override
   public void interrupt(){
     super.interrupt();  
     this.socket.close();
   }
}