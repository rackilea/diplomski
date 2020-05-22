/**
 * This request body makes it possible for another
 * thread to stream data to the uploading request.
 * This is potentially useful for posting live event
 * streams like video capture. Callers should write
 * to {@code sink()} and close it to complete the post.
 */
static final class PipeBody extends RequestBody {
  private final Pipe pipe = new Pipe(8192);
  private final BufferedSink sink = Okio.buffer(pipe.sink());

  public BufferedSink sink() {
    return sink;
  }

  @Override public MediaType contentType() {
    ...
  }

  @Override public void writeTo(BufferedSink sink) throws IOException {
    sink.writeAll(pipe.source());
  }
}