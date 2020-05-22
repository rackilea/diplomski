public class Person {
   String name;
   int age;
   boolean smoker;

   ...

   public String toString() {
     return new ToStringBuilder(this).
       append("name", name).
       append("age", age).
       append("smoker", smoker).
       toString();
   }
 }