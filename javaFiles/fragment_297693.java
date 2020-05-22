public class StatusListener implements Service<PacketData> {

   // ...

   @Override
   protected Task<PacketData> createTask() {
      return new Task<PacketData>() {
          // ...

          @Override
          public PacketData call() {
              // ...
              while (! isCancelled()) { 
                  // receive packet, parse data, and wrap results:
                  PacketData data = new PacketData(...);
                  updateValue(data);
              }
              return null ;
          }
      };
   }
}