abstract class A {
   public abstract int getConst();
}

public class B extends A {
   @Override
   public int getConst() { return 1; }
}

public class C extends A {
   @Override
   public int getConst() { return 2; }
}

public static void main(String[] args){
    A a = new B();
    System.out.println(a.getConst());
}