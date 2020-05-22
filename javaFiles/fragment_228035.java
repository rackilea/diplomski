public class FactoryClass<M extends IADataType, R extends IBDataType> {

    public static final FactoryClass<ABoolean, BBoolean> BOOLEAN = new FactoryClass<ABoolean, BBoolean>() {

        @Override
        public BooleanConverter getInstance() {
            return new BooleanConverter();
        }

        @Override
        public BooleanConverter getInstance(BBoolean bacStacDataType) {
            return new BooleanConverter(bacStacDataType);
        }

    };

    public abstract IConverter<M, R> getInstance();

    public abstract IConverter<M, R> getInstance1(R data);
}