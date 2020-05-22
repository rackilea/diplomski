public class APartitialMock extends A {

   protected B newB(){
      return new BMock();
   }
}

public class BMock extends B {

    int func2(something) {
        return 5
    }

}