@Override
protected void configure() {
    bind(ActorSystem.class).toInstance(ActorSystem.apply());
    bind(FizzService.class).toInstance(new FizzServiceImpl());
}

@Provides @Singleton @Named("fizzActor")
ActorRef serviceActorRef(final ActorSystem system, final FizzService fizzService) {
    return system.actorOf(Props.create(new Creator<Actor>() {
        @Override
        public Actor create() throws Exception {
            return new FizzActor(fizzService);
        }
    }));
}