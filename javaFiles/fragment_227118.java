public class SomeMagicalModule extends AbstractModule implements AkkaGuiceSupport {

  @Provides
  @Singleton
  @Named("some-actor")
  ActorRef createActor(system: ActorSystem){
    system.actorOf(...)
  }
}