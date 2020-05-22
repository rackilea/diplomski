@Override
public Mono<Void> handle(WebSocketSession session) {
  final UnicastProcessor<ResponseMessage<?>> funIn = UnicastProcessor.create(Queues.<ResponseMessage<?>>unboundedMultiproducer().get());
  ...

  return Mono
    .subscriberContext()
    .flatMap(context -> Flux.merge(
      session
        .receive()
        ...
        .cast(ActionMessage.class)
        .publishOn(Schedulers.parallel())
        .doOnNext(am -> {
          switch (am.type) {
            case CREATE:
            case UPDATE:
            case CANCEL: {
              ...
            }
            case SUBSCRIBE: {
              Flux<ResponseMessage<?>> flux = Flux
                .from(
                  channelsMapping.get(am.getChannelId())
                                 .get(ActionMessage.Type.SUBSCRIBE)
                                 .handle(am) // returns Publisher<>
                );

              if (flux != null) {
                channelsIdsToDisposableMap.compute(
                  am.getChannelId() + am.getSymbol(), // you can generate a uniq uuid on the client side if needed
                  (cid, disposable) -> {
                    ...

                    return flux
                      .subscriberContext(context)
                      .subscribe(
                        funIn::onNext, // send message to a Processor manually
                        e -> {
                          funIn.onNext(
                            new ResponseMessage<>( // send errors as a messages to Processor here
                              0,
                              e.getMessage(),
                              ...
                              ResponseMessage.Type.ERROR
                            )
                          );
                        }
                      );
                  }
                );
              }

              return;
            }
            case UNSABSCRIBE: {
              Disposable disposable = channelsIdsToDisposableMap.get(am.getChannelId() + am.getSymbol());

              if (disposable != null) {
                disposable.dispose();
              }
            }
          }
        })
        .then(Mono.empty()),

        funIn
            ...
            .map(p -> new WebSocketMessage(WebSocketMessage.Type.TEXT, p))
            .as(session::send)
      ).then()
    );
}