public class ProcessOrder {
   private void login() {
       synchronized(ProcessOrder.class) {
           // one at a time, please
       }
   }
}