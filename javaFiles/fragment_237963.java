public static void main(String[] args) throws Exception {
    if (new ArgumentsValidator().validate(args)) {
        // If the arguments are valid then we can load spring application
        // context on here.
        final ApplicationContext context = new AnnotationConfigApplicationContext(
                M6ApplicationContext.class);

        // Use an akka system to be able to send messages in parallel
        // without doing the low level thread manipulation ourselves.
        final ActorSystem system = context.getBean(ActorSystem.class);
        final Future<Terminated> workDone = system.whenTerminated();
        final ActorRef runCoordinator = system.actorOf(SPRING_EXT_PROVIDER.get(system)
                .props("RunCoordinatorActor"), "runCoordinator");
        runCoordinator.tell(new StartTesting(), ActorRef.noSender());

        do {
            LOGGER.info("Waiting for the process to finish");
            Thread.sleep(60000L);
        } while (!workDone.isCompleted());
    }
}