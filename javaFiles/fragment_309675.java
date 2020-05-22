public interface ITransformer<S, T> {

    void transform(S source, T target);

    String getTransformerName();
}

public abstract class BaseITransformer<S, T> implements ITransformer<S, T> {

    private final Class<S> sourceClass;
    private final Class<T> targetClass;

    public BaseITransformer(Class<S> sourceClass, Class<T> targetClass) {
        this.sourceClass = sourceClass;
        this.targetClass = targetClass;
    }

    public String getTransformerName() {
        return sourceClass.getName() + targetClass.getName();
    }
}