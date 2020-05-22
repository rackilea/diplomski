public class ArrayWalker<T> {

    T[] t;

    public ArrayWalker(T[] t) {
        this.t = t; 
    }

    public void function(T t) {}

    public ArrayWalker<T> walk() {
        for (int i=0; i<t.length; i++) {
            function(t[i]);
        }
        return this;
    }
}