public class MyAdapterFactory implements AdapterFactory {
    public boolean isFactoryForType(Object o) {
        return (o instanceof MyModel);
    }
    public Adapter adapt(Notifier notifier, Object type) {
        return mySwitch.doSwitch((EObject)notifier);
    }
}