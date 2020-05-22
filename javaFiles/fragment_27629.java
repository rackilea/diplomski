public interface Foo {

    void bar();

}

public class ThirdPartyFooWrapper implements Foo {

     private SomeOldClass oldClass;

     public ThordPartyFooWrapper (SomeOldClass oldClass){
          this.oldClass = oldClass;
     }

     @Override
     public void bar() {
         this.oldClass.bar();
     }

}