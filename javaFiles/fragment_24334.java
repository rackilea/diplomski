public class<T extends Comparable> LessThanX() implements ConditionBase<T>
{
   ...
   private T value;

   ...
   public boolean fullfills(T object)
   {
      return object.compareTo(value) < 0;
   }
}