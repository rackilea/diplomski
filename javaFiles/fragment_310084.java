private Flowable<Buffer> akkaConversion(Source<ByteString, NotUsed> data,
        Flow<ByteString, ByteString, NotUsed> compType) {

    return Flowable.defer(() -> data.via(compType)
         .runWith(Sink.asPublisher(AsPublisher.WITHOUT_FANOUT), this.materializer) 
    ).map(bytes -> Buffer.buffer(bytes.toArray()));
}