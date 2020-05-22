public abstract class AliveBeing<T> {
    protected T livingBeing;
    public AliveBeing(T livingBeing) {
        this.livingBeing = livingBeing;
    }
}

public class Person extends AliveBeing<Man> {
    //now your livingBeing field is from Man type...
    public Person(Man man) {
        super(man);
    }
}