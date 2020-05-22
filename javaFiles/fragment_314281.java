package p1;

public class C1 {
    protected void nonStatic() {}
    protected static void isStatic() {}
}

----
package p2;

import p1.C1;

public class C2 extends C1 {
   public void someMethod() {
     super.nonStatic();
     C1.isStatic();     // or even C2.isStatic()
   }
}