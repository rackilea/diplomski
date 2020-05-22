class SomeClass
{
   int xPosition, yPosition;
   enum Type
   {
      Boat, Mine
   }
   public SomeClass(Type type)
   {
      if (type == Type.Boat)
      {
         xPosition = 3;
         yPosition = 4;
      }
      else
      {
         xPosition = 1;
         yPosition = 1;
      }
      // assign 'type' to a class variable here if required
   }
}