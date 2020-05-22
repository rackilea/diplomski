public class SomeClass implements Comparable<SomeClass>
{
   private String someField;

   public int compareTo(final SomeClass o)
   {
     int res = 0;

     if (someField.startsWith("BB") && o.someField.startsWith("BB"))
     {
       res = o.someField.compareTo(someField);
     }
     else
     {
       res = someField.compareTo(o.someField);
     }
     return res;
   }
}