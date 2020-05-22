class FruitKey<T extends Fruits>
{
   int                     id;
   Class<T> type;

   public FruitKey( int id, Class<T> type )
   {
      this.id = id;
      this.type = type;
   }     
}