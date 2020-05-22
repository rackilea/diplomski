@Singleton
@Provides
@Inject
public List<Foo> foos(OneFoo one, TwoFoo two) {
    return Collections.unmodifiableList(Arrays.asList(one, two));
}