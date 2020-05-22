public interface Modifiable<T extends Modifiable<T>> extends Cloneable {
    T clone();
}

public class Foo implements Modifiable<Foo> {
    public Foo clone() { //this is required
        return null; //todo: real work
    }
}