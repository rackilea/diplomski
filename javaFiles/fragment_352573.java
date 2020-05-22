public class GenRemoteDataSource<E extends SomeClass>
{
   //...
   private final Class<E> clazz;

   GenRemoteDataSource(Class<E> clazz)
   {
      this.clazz = clazz;
   }

   //...
   public void onDataChange(DataSnapshot dataSnapshot)
   {
        E item = dataSnapshot.getValue(clazz); // <- now is type safe.
        items.add(item);
   }
}