public class MyClass1 implements Interface1 {
   public void call1() {}
   public call call2() {}
}

public class MyClass2 implements Interface2 {
   public void call3() {}
   public void call4() {}
}

public class MyClass {
   private MyClass1 a;
   private MyClass2 b;
   //calling methods call1 call2 call3 and call4 in other methods of this class
   ...
   ...
}