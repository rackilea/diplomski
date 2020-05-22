class Car {

   ...

   public int speed() {

      // This is an arbitrary operation for the sake of me not
      // having to learn how engines work. Ahem.

      return engine.power() * 842; 
   }

   public Engine engine; // Assume this class is defined elsewhere

   ...
}