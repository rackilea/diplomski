...
.subscribeWith(incoming)
.doOnNext(message -> {
    if (monoSinkMap.containsKey(message.getStreamId())) {
        MonoSink sink = monoSinkMap.get(message.getStreamId());
        monoSinkMap.remove(message.getStreamId());
        if (message.getType() == SUCCESS) {
            sink.success(message.getData());
        }
        else {
            sink.error(message.getCause());
        }
    } else if (fluxSinkMap.containsKey(message.getStreamId())) {
        FluxSink sink = fluxSinkMap.get(message.getStreamId());
        if (message.getType() == NEXT) {
            sink.next(message.getData());
        }
        else if (message.getType() == COMPLETE) {
            fluxSinkMap.remove(message.getStreamId());
            sink.next(message.getData());
            sink.complete();
        }
        else {
            fluxSinkMap.remove(message.getStreamId());
            sink.error(message.getCause());
        }
    }
})