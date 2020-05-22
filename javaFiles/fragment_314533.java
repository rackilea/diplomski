private Mono<Void> createSpreadsheet(Flux<DataBuffer> body) {
    try {
        Path file = //...
        WritableByteChannel channel = Files.newByteChannel(file, StandardOpenOption.WRITE);
        return DataBufferUtils.write(body, channel).map(DataBufferUtils::release).then();
    } catch (IOException exc) {
        return Mono.error(exc);
    }
}