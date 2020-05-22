public abstract class BaseClass<T extends BaseClass> {
    private Alpha a;
    private Beta b;

    public Alpha getAlpha() {
        return a;
    }

    public Beta getBeta() {
        return b;
    }

    @SuppressWarnings("unchecked")
    public T setAlpha(Alpha a) {
        this.a = a;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T setBeta(Beta b) {
        this.b = b;
        return (T) this;
    }
}