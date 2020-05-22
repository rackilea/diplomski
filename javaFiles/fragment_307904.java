class A {
    B b = new B("b");
}
class B {

}

$javac A.java 

A.java:2: cannot find symbol
symbol  : constructor B(java.lang.String)
location: class B
    B b = new B("b");
          ^
1 error