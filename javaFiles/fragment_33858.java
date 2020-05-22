public class GenericType<T> {
   public class Inner extends T {   }

   public static void main(String...args) {
      GenericType<MyClass>.Inner obj = new GenericType<MyClass>().new Inner();
      System.out.println(obj instanceof MyClass); // Prints true
   }
}