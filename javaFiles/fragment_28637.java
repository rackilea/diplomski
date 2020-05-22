public abstract class AbstractTestModel<T extends AbstractTestModel> {

    public T doSomething() {
        return getThis();
    }

    public T getThis() {
        return (T) this;
    }

    public <U extends AbstractTestModel> U as(Class<U> type) {
        if (getClass().isAssignableFrom(type)) {
            return type.cast(this);
        } else {
            throw new AssertionError("This (" + getClass().getName()
                + ") could not be resolved to the expected class " + type.getName());
        }
    }

}

class ConcreteTestModel1 extends AbstractTestModel<ConcreteTestModel1> {

    public void doSomethingElse() {
        System.out.println("This is \"" + getClass().getSimpleName() + "\" doing something else");
    }
}

class ConcreteTestModelX extends ConcreteTestModel1 {

}