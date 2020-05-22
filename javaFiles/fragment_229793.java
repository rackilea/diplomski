import java.util.List;
class SampleClass {

     static class Baz<T> {
         public static List<Baz<Object>> sampleMethod(Baz<Object> param) {
             return null;
         }
     }

     private static void bar(Baz arg) {
         Baz element = Baz.sampleMethod(arg).get(0);
     }
}