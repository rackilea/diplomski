@Mapper(decoratedWith=MyMapperDecorator.class)
public interface MyMapper {
    A cAndDToA(C c, D d);
    B cAndDToB(C c, D d);
}

public abstract class MyMapperDecorator implements MyMapper {

    private final MyMapper delegate;

    public MyMapperDecorator(MyMapper delegate) {
        this.delegate = delegate;
    }

    @Override
    public A cAndDToA(C c, D d) {
        A a = delegate.cAndDToA( c, d );
        a.setB( cAndDToB( c, d );

        return a;
    }
}