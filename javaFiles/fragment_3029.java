package de.leonso.test;

public class A {
    public String a(B b) {
        return b.b();
    }
}

package de.leonso.test;

public class B {
    public String b() {
         return ("hallo");
    }
}