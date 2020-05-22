abstract class Test1  {} 
class Test2 extends Test1{ }

class Test<T> {
   public static <T extends Test1> T foo(Class<T> clazz) {
     T toReturn = null;
     try{ toReturn = clazz.newInstance(); } catch (Exception e) { };
     return toReturn ;
  }

  public static void main(String[] args) {
    Test1 t1 = t.foo(test2.class);
    System.out.println(t1.getClass()); //prints "class pkgname.test2"
  }
}