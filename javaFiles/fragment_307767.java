UnicastProcessor<> outgoing = ...
UnicastPorcessor<> incoming = ...
(session) -> {
  return Flux.merge(
     session.receive()
            .subscribeWith(incoming)
            .then(Mono.empty()),
     session.send(outgoing)
  ).then();
}