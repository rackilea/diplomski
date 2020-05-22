public abstract class Agent2 extends Agent1{
    public void actOn(Object o){

        actOn(o, i); // what is i ???
    }
    public abstract void actOn(Object o, int i);
}

public abstract class Agent1 {
    public abstract void actOn(Object o);
    public void repeat(Object o, int i) {
       for (int j = 1; j <= i; j++) {
           actOn(o);
       }
    }
}