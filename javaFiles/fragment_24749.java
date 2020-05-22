UnicastProcessor<String> processor = UnicastProcessor.create();
FluxSink<String> fluxSink = processor.sink(FluxSink.OverflowStrategy.LATEST);
//change 'publish()' to 'replay()'
Flux<String> hotFlux = processor.publish().autoConnect(); 

hotFlux.subscribe(n -> log.info("1st subscriber: {}", n));

fluxSink.next("one");

hotFlux.subscribe(n -> log.info("2nd subscriber: {}", n));

fluxSink.next("two");