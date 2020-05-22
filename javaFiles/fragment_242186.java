import java.lang.reflect.Type;

interface Notifier<T> { }

class Foo implements Notifier<String> {
}

class Test {
   public static void main(String[] args) {
       Class<?> clazz = Foo.class;
       for (Type iface : clazz.getGenericInterfaces()) {
           System.out.println(iface);
       }
   }
}