public class MyClass {


    void doIt(){
        doSomething(new ConcreteThing());       
    }

    private <T extends IAnything> void doSomething(T kindOfAbstractClass) {

            kindOfAbstractClass.m1();
            kindOfAbstractClass.m3();
    }

}


interface IAnything {
      void m1();
      void m3();
}

abstract class AbstractThing1 implements IAnything {
      public void m1() {}
      public void m3() {}
}


class ConcreteThing extends AbstractThing1{

}