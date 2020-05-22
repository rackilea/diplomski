public abstract class Module<P extends Port> {

   protected Map<String, P> ports;

   public Map<String, P> getPorts() {
      return ports;
   }
}


class Design extends Module<TopPort> { }