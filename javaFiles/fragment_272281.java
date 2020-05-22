public class Test {
        public String hello;
    }
    public class StackOverflow {
      public static void main(String[] args) {
        Test test = new Test();
        test.hello = "Hello world";
        System.out.println(test.hello);
      }
    }