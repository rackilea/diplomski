@Root(name="root")
class Root {

   @ElementUnion({
       @Element(name="B", type=B.class),
       @Element(name="C", type=C.class)
   })
   private A a;
}

class A {

}

class B extends A {

}

class C extends A {

}