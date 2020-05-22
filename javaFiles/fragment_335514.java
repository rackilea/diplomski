portected abstract class BaseClassBuilder<T extends BaseClass, BU extends BaseClassBuilder<T, BU>> {
    protected T obj;
    private BU self;

    protected BaseClassBuilder (T obj, Class<?> selfType) {
        this.obj = obj;
        this.self = (BU) selfType.cast(this);
    }

    final BU getThis () {
        return self;
    }

    public BU withField1 (Integer field1) {
        obj.setField1(field1);
        return getThis();
    }

    public T build () {
        return this.obj;
    }
}