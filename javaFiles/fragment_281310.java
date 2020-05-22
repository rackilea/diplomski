public abstract class AbstractFoo<T>  {

    public void process(T a) {

        //do common processing

        doProcess(a);
    }

    protected abstract void doProcess(T a);
}

public class Person extends AbstractFoo<Person> {
    @Override
    protected void doProcess(Person p) {
        p.draw();
    }
}


public class Car extends AbstractFoo<Car> {
    @Override
    protected void doProcess(Car c) {
        c.draw();
    }
}