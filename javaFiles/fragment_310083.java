public abstract class AbstractParent<T extends AbstractObject> {
    protected T subMePlz;
    // ... some fields that all subclasses need
    public AbstractParent() {
        this.subMePlz = createThisInYourExtendedClass();

    }

    public abstract T createThisInYourExtendedClass();
} 

public class ExtendParent extends AbstractParent<ConcreteObject> {
    ...
}