class ClientData {
  // This is immutable after creation (like your OP)
  class Mappings { /* definition from your original post */ }

  // this should be volatile;
  private static volatile Mappings instance;

  // the read path proceeds without acquiring any lock at all.  Hard to 
  // get faster than a volatile read.  Note the double-checked locking pattern
  // works JDK 6 or greater when using volatile references (above)
  public static Mappings getMappings() {
    Mappings result = instance;
    if(result == null) {
       synchronized(ClientData.class) {
          result = instance;
          // recall while() is required to handle spurious wakeup
          while(result == null) {
             ClientData.class.wait();
             result = instance;
          }
       }
    }
  }

  public static setMappings(Map one, Map two, Map three) {
    synchronized(ClientData.class) {
      instance = new Mappings(one,two,three);
      ClientData.class.notifyAll()
    }
  }
}