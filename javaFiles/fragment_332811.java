// Class Car provides the public API to interact with a car, but
// it delegates the specific functionalies to its inner classes.
public class Car {
   private Startup startup;
   private CoreEngine core;
   // ...
   private class Startup {
      // The class can access to 'core', then it can 
      // invoke rotate() method
      public void main() { /* ... */ } 
   }
   private class CoreEngine {
      public void rotate() { /* ... */ }
   }
}