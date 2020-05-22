package p1;

public class MyClass1 {

    protected String protectedString = "example";

    protected static String protectedStaticString = "example";

}

package p2;

import p1.MyClass1;

public class MyClass2 extends MyClass1 {

    public void testProtected() {

        MyClass1 otherMC1 = new MyClass1();
        MyClass2 otherMC2 = new MyClass2();

        String testProtected;

        testProtected = this.protectedString; // OK, protectedString is inherited, so it's instance member of this class
        testProtected = super.protectedString; // OK, it's also instance member of superclass

        testProtected = otherMC1.protectedString; // ERROR. You can't access protected members of other instance of superclass
        testProtected = otherMC2.protectedString; // OK. As it's inherited member of MyClass2, you can access it if it belongs to other instance of your class

    }

    public void testProtectedStatic() {

        MyClass1 otherMC1 = new MyClass1();
        MyClass2 otherMC2 = new MyClass2();

        String testProtectedStatic;

        testProtectedStatic = this.protectedStaticString; // OK - syntax trick
        testProtectedStatic = super.protectedStaticString; // OK - syntax trick

        testProtectedStatic = otherMC1.protectedStaticString; // OK - syntax trick
        testProtectedStatic = otherMC2.protectedStaticString; // OK - syntax trick

        testProtectedStatic = MyClass1.protectedStaticString; // OK - you can access protected static members from superclass
        testProtectedStatic = MyClass2.protectedStaticString; // OK - this also static member of your class
    }

}