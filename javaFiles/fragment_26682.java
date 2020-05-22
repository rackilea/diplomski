public class TestFactory {
   public static ITest<?> getInstance(int type) {
      if(type == 1) 
         return new test1();
      else if(type == 2) 
         return new test2();
      else
         throw new IllegalArgumentException("Unknown type");
   }

   public static <T> ITest<T> getInstance(Class<T> clazz) {
      if(clazz == String.class) 
         return new test1();
      else if(clazz == Integer.class) 
         return new test2();
      else 
         throw new IllegalArgumentException("Unknown type");
   }
}