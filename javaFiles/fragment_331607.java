public class A {
   public static void blah() { System.err.println("I'm an A"); }
}

public class SubA extends A {
   public static void blah() { System.err.println("I'm a SubA"); }
}

public class B { 
   public static A getA(){ return new SubA(); }
}

B.getA().blah(); //prints "I'm an A".