final class MyContract extends Contract{
    // parameter-less ctor will be handeled by annotation processor
    public MyContract(){
        super(
            new ExclusiveOr(
                new IsType(IAtomicType.class),
                new Or(
                    new IsType(IListType.class),
                    new IsType(ISetType.class)
                )
            )
        );
    }
}