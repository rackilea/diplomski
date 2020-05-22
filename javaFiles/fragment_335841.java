public class B implements IB {  

    protected final A a;

    @AssistedInject
    public B(@Assisted String name, IAFactory iaFactory) {
        this.a = iaFactory.create(name);
    }
}