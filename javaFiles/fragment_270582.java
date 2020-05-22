public abstract class Factory {
    public abstract A getInstance(object o, enum e);
}

public class FactoryB extends Factory {
    @Override
    public B getInstance(object o,enum e){
         //do something with enums and get B
         b = new B();
         //populate b
         return b;
    }
}