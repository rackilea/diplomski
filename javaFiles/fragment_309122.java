@Component
public class Bean1 implements EnumMappedBean {
    @Override
    public SomeEnum getSomeEnum() {
        return SomeEnum.ENUM1;
    }
}

@Component
public class Bean2 implements EnumMappedBean {
    @Override
    public SomeEnum getSomeEnum() {
        return SomeEnum.ENUM2;
    }
}