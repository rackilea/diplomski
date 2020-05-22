public class UserFactory {
  private Map<String, Class<? extends MusicInterface>> musicMap =
      ImmutableMap.builder()
        .put("user1", RockMusic.class)    // You could also put instances here
        .put("user2", PopMusic.class)     // and skip using Guice entirely!
        .build();

  // Never inject Injector unless you don't know what you need until runtime,
  // which is exactly what is happening here.
  @Inject private Injector injector;
  @Inject private Provider<Dependency> someOtherUserDependency;

  public User createUser(String musicType) {
    Class<? extends MusicInterface> clazz = musicMap.get(musicType);
    return new User(injector.getInstance(clazz), someOtherUserDependency.get());
  }
}