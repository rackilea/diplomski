public class MyModule extends AbstractModule {
  @Override public void configure() {
    bind(A.class).to(AImpl.class).in(Singleton.class);

    bind(B.class).to(BImpl.class);
    bind(BImpl.class).in(Singleton.class);
  }

  @Provides @Singleton C provideC() { return new CImpl(); }

  @Provides @Singleton D provideD(DImpl dImpl) { return dImpl; }

  @Provides E provideE(EImpl eImpl) { return eImpl; }
  @Provides @Singleton EImpl provideEImpl() { return new EImpl(); }
}