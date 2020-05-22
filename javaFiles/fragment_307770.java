Mono<R> sendForMono(T data) {
        //generate message with unique 
        return Mono.<R>create(sink -> {
            monoSinksMap.put(streamId, sink);
            outgoing.onNext(message); // send message to server only when subscribed to Mono
        });
    }

     Flux<R> sendForFlux(T data) {
         return Flux.<R>create(sink -> {
            fluxSinksMap.put(streamId, sink);
            outgoing.onNext(message); // send message to server only when subscribed to Flux
        });
     }
}