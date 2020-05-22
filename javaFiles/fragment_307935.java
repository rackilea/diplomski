class Animals extends 
{
   private final Vector<Animal> inner = new Vector<Animal>();

   public Animals(Zebra z) { add(z); }

   // Delegate to whatever methods of Vector that Animals need to support, e.g.,
   void add(Animal a) { inner.add(a); }

   ...
}