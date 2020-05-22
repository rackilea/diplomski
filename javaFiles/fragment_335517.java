public class AbstractSubSubClassBuilder<T extends SubSubClass, BU extends AbstractSubSubClassBuilder<T, BU>> extends AbstractSubClassBuilder<T, BU> {

   protected AbstractSubSubClassBuilder (T obj, Class<BU> selfType) {
        super(obj, selfType);
    }

    public BU withField3 (String field3) {
        obj.setField3(field3);
        return getThis();
    }
}