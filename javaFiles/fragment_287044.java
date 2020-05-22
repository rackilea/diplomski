@Getter(lazy=true)
SomeType t = initializeT();

private SomeType initializeT() {
    return <complicatedInitializationCode>;
}