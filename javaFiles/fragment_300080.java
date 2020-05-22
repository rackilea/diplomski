@Root(name="root")
class Root {

   @ElementUnion({
       @Element(name="B", type=B.class),
       @Element(name="C", type=C.class)
   })
   private A a;
}

interface A {

}

class B implements A {

}

class C implements A {

}