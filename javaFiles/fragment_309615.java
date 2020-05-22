Flux<ResultMessage> sendRequest(RequestMessage message) {
  final int maxResponsesCount = 2;
  final Duration responseTimeout = Duration.ofSeconds( 10 );
  final Duration subscriptionTimeout = Duration.ofSeconds( 5 );

  // (1) 
  ConnectableFlux<ResultMessage> result = incomingMessageStream
      .ofType( ResultMessage.class )
      .filter( resultMessage ->Objects.equals(resultMessage.getId(), message.getId() ) )
      .take( maxResponsesCount )
      .timeout( responseTimeout )
      .replay( maxResponsesCount );
  Disposable connectionDisposable = result.connect();

  // (2)
  AtomicReference<Subscription> subscriptionForCancelSubscription = new AtomicReference<>();
  Mono.delay( subscriptionTimeout )
    .doOnSubscribe( subscriptionForCancelSubscription::set )
    .subscribe( x -> connectionDisposable.dispose() );

  // The message sending is done here...

  // (3)
  return result
    .doOnSubscribe(s ->subscriptionForCancelSubscription.get().cancel())
    .doFinally( signalType -> connectionDisposable.dispose() );
}