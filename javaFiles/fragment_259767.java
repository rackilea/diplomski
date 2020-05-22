public interface FooSpi { 
   void accepts(String url);
   FooInterface getFooInstance();
}


public class FooInterfaceFactory {
  public static FooInterface getFooInterfaceInstance(String url) {
    ServiceLoader<FooSpi> loader = ServiceLoader.load(FooSpi.class);
    Iterator<FooSpi> it = loader.iterator();
    while (it.hasNext()) {
       FooSpi fooSpi = it.next();
       if (fooSpi .accepts(url)) {
         return fooSpi.getFooInstance();
       }
    }

    return null;
  }
}