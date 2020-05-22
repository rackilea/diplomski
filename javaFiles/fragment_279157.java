public class StringDecoder extends AbstractDecoder<String> {
    private static final IntPredicate NEWLINE_DELIMITER = b -> b == '\n' || b == '\r';

    @Override
    public Flux<String> decode(Publisher<DataBuffer> publisher, ResolvableType elementType, MimeType mimeType, Map<String, Object> hints) {
        DataBuffer incomplete = new NettyDataBufferFactory(UnpooledByteBufAllocator.DEFAULT).allocateBuffer(0);

        return Flux.from(publisher)
                .scan(Tuples.<Flux<DataBuffer>, DataBuffer>of(Flux.empty(), retain(incomplete)),
                      (acc, buffer) -> {
                          List<DataBuffer> results = new ArrayList<>();
                          int startIdx = 0, endIdx = 0, limit = buffer.readableByteCount();

                          while (startIdx < limit && endIdx != -1) {
                              endIdx = buffer.indexOf(NEWLINE_DELIMITER, startIdx);
                              int length = (endIdx == -1 ? limit : endIdx) - startIdx;

                              DataBuffer slice = buffer.slice(startIdx, length);
                              byte[] slice1 = new byte[length];
                              slice.read(slice1, 0, slice1.length);

                              if (endIdx != -1) {
                                  byte[] slice2 = new byte[incomplete.readableByteCount()];
                                  incomplete.read(slice2, 0, slice2.length);
                                  // call retain to match release during decoding to string later
                                  results.add(retain(
                                          incomplete.factory().allocateBuffer()
                                                  .write(slice2)
                                                  .write(slice1)
                                  ));
                                  startIdx = endIdx + 1;
                              } else {
                                  incomplete.write(slice1);
                              }
                          }

                          return Tuples.of(Flux.fromIterable(results), incomplete);
                      })
                .flatMap(Tuple2::getT1)
                .map(buffer -> {
                    // charset resolution should in general use supplied mimeType
                    String s = UTF_8.decode(buffer.asByteBuffer()).toString();

                    return s;
                })
                .doOnTerminate(() -> release(incomplete))
                .log();
    }
}