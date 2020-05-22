// drain the body
response.body(BodyExtractors.toDataBuffers())
    // release DataBuffers
    .doOnNext(DataBufferUtils::release)
    // ignore errors
    .onErrorResume(exception -> Mono.empty())
    // return an empty Mono
    .then();