public interface Sequence {
    public void methodOne();
    public int methodTwo();
}

public abstract class AbstractSequence  implements Sequence {


    public SequenceWrapper( ){  }

    public void methodOne(){
        //basic behavior here
    }

    public int methodTwo(){
         //basic behavior here

    }
}

public class ConcreteSequence extends AbstractSequence {
    public ConcreteSequence ( ){
         super( );
    }

    // Just an example
    public int addMethodOne(){
         int a =  methodTwo();
         return a + 3;
    }        
}


public class ConcreteSequenceTwo extends AbstractSequence {
    public ConcreteSequenceTwo( ){
         super( );
    }

    public int addMethodTwo(){
         int a =  methodTwo();
         return a + 30;
    }
}