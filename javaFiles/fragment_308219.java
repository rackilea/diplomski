@GetMapping(value = "/getValue/{randomId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
public Flux<String> statusCheck(@PathVariable("randomId") @NonNull String randomId) {
    EmitterProcessor<String> emitterProcessor = EmitterProcessor.create();
    Flux<String> autoConnect = emitterProcessor.publish().autoConnect();
    FluxSink<String> sink = emitterProcessor.sink();
    //storing randomId and processor sink details
    randomIdMap.putIfAbsent(randomId, emitterProcessor);
    /** This will return ping status to notify client as 
    connection is alive until the randomId message received. **/
    sendPingStatus(sink, randomId);
}