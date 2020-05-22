public class HandlerImpl<TYPE1, TYPE2, TYPE3> implements Handler<TYPE1, TYPE2, TYPE3>{

    private Strategy<TYPE1, TYPE2, TYPE3> strategy;

    public HandlerImpl(Strategy<TYPE1, TYPE2, TYPE3> strategy){
        this.strategy = strategy;
    }

    public void doSomething(TYPE1 t1, TYPE2 t2, TYPE3 t3){
        // do your business using "strategy"
    }

    public void doSomethingElse(TYPE3 t3){
        // do your business using "strategy"
    }

}