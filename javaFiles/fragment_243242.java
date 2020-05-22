public abstract class AbstractPythonService<S> implements FactoryBean<S> {
    private final Class<S> type;

    protected AbstractPythonService(Class<S> type) {
        super(type); // Probably the factory would also need the type.
        this.type = type;
    }

    return type.cast(buildingObject.__tojava__(type)); // type.cast probably unneeded.

public Class<S> getObjectType() {
    return type;
}