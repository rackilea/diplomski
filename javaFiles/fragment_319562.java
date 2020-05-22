public class MyModule extends AbstractModule {
  @Override protected void configure() {
    install(privateModuleFor("user1", RockMusic.class));
    install(privateModuleFor("user2", PopMusic.class));
  }

  private static Module privateModuleFor(
      final String userName, final Class<? extends MusicInterface> musicClass) {
    return new PrivateModule() {
      @Override protected void configure() {
        // Bind the annotated user.
        bind(User.class).annotatedWith(Names.named(userName)).to(User.class);
        // Now bind the music class as if it's the only music class ever.
        bind(MusicInterface.class).to(musicClass);
        // The above two bindings are hidden, and available only in this module,
        // so Guice doesn't complain about two different competing
        // MusicInterfaces. In order to get access to the User binding
        // outside the module, expose it.
        expose(User.class).annotatedWith(Names.named(userName));
      }
    };
  }
}