public abstract class AbstractSubClassBuilder<T extends SubClass, BU extends AbstractSubClassBuilder<T, BU>> extends BaseClassBuilder<T, BU> {

    protected AbstractSubClassBuilder(T obj, Class<?> selfType) {
        super(obj, selfType);
    }

    public BU withField2 (UUID field2) {
        obj.setField2(field2);
        return getThis();
    }
}