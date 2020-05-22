public class A {
   D d;
   A(D dObject){
     this.d = dObject;
   }
   public void add () {
     d.add(5);
   }
}

public class B {
   D d;
   B(D dObject){
     this.d = dObject;
   }
   public void add () {
     d.add(5);
   }
}

public class C {
   D d;
   C(D dObject){
     this.d = dObject;
   }
   public void add () {
     d.add(5);
   }
}
public class D {
   public int x=0;
   public void add (int y){
      x +=y;
   }
}

// in main class:
D d = new D();
A a = new A(d);
B b = new B(d);
C c = new C(d);

a.add();
b.add();
c.add();

// d.x should give 15 now.