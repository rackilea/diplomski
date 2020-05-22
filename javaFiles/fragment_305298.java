//Scala
class A {
  val a = Map[String, Any]("a" -> 1) //it's `Any` but fits to AnyRef/Object
}

//Java
public class B {
    public static void main(String[] args) {
        A a = new A();
        scala.collection.immutable.Map<String, Object> map = a.a(); //it's AnyRef/Object and btw fits only to AnyRef if you'd try to use it from Scala
        System.out.println("Hello World!" + map.apply("a"));
    }
}