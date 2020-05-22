public interface BodyWrapper {
   Object doStuff();
}

public class DOMBodyWrapper implements BodyWrapper {
   public Object doStuff() {
   }
}

public class JSONBodyWrapper implements BodyWrapper {
   public Object doStuff() {
      // do something and return a success/failure result. I've
      // deliberately not defined what this object is....
   }
}