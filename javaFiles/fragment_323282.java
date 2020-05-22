@Rule @Bind
public final TestName name = new TestName();


@Before
public void injectMembers() {
  Guice.createInjector(
      BoundFieldModule.of(this);
      new TestModule())
      .injectMembers(this);
}