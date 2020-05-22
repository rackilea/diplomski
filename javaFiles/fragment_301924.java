@MapKey
@interface SomeEnumKey {
    SomeEnum value();
}

@Provides 
@IntoMap
@SomeEnumKey(SomeEnum.A1)
Action action1(@Named("dep1") Dependency dep1) {
    return new Action1(dep1);
}

@Provides 
@IntoMap
@SomeEnumKey(SomeEnum.A2)
Action action2(@Named("dep2") Dependency dep2) {
    return new Action2(dep2);
}

@Provides 
ActionResolver provideActionResolver(Map<SomeEnum, Action> actions) {
    return new ActionResolver(actions);
}