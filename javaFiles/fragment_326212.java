public abstract class Agent1 extends Agent2{
    public void actOn(Object o, int i){
        // do something with i
        actOn(o);
    }
    public abstract void actOn(Object o);
}

public abstract class Agent2 {
    public abstract void actOn(Object o, int i);
    public void repeat(Object o, int i) {
        for (int j = 1; j <= i; j++) {
            actOn(o, j);
        }
    }
}