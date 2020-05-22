public class TVDBActor extends UntypedActor {

  @Inject
  public void preStart(final ActorSystem system, @Named("TVDBActor") ActorRef tvdbActor) {
    system.scheduler().schedule(
      Duration.create(12, TimeUnit.HOURS),
      Duration.create(12, TimeUnit.HOURS),
      tvdbActor,
      "tick",
      system.dispatcher(),
      null
    );
  }

  @Override
  public void onReceive(Object msg) throws Exception {
    TVDB.refreshToken();
  }

}