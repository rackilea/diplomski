@Bean
@Scope(SCOPE_PROTOTYPE)
public SynchronousRpcProxy myBean(MyObj1 notNull1, MyObj2 notNull2,
                                  Optional<MyNullable> canBeNull) {
    return new SmthFromExternalLib(notNull1, notNull2, canBeNull.orElse(null));
}