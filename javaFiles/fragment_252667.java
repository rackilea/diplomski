public interface MyInterface {

      MyInterface DEFAULT = new MyDefaultImplementation();

      public static class MyDefaultImplemenation implements MyInterface {
      }
 }