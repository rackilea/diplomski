@Override
public Receive createReceive() {
  return receiveBuilder()
    .match(Init.class, init -> {
      log.info("Sending myself a Poison Pill...");
      self().tell(PoisonPill.getInstance(), ActorRef.noSender());
    })
    .build();
}

@Override
public void postStop() {
  getContext().getSystem().terminate();
}