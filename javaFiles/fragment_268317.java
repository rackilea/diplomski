private final MessageDispatcher fileServeContext = Akka.system().dispatchers().lookup("file-serve-context");

protected void serveInputStream(InputStream inputStream, String fileName, long contentLength) {
    response().setHeader(
            HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"" + fileName + "\"");

    // Set Content-Type header based on file extension.
    scala.Option<String> contentType = MimeTypes.forFileName(fileName);
    if (contentType.isDefined()) {
        response().setHeader(CONTENT_TYPE, contentType.get());
    } else {
        response().setHeader(CONTENT_TYPE, ContentType.DEFAULT_BINARY.getMimeType());
    }

    response().setHeader(CONTENT_LENGTH, Long.toString(contentLength));

    return new WrappedScalaResult(new play.api.mvc.Result(

        new ResponseHeader(StatusCode.OK, toScalaMap(response().getHeaders())),

        // Enumerator.fromStream() will also close the input stream once it is done.
        play.api.libs.iteratee.Enumerator$.MODULE$.fromStream(
            inputStream,
            FILE_SERVE_CHUNK_SIZE,
            fileServeContext),

        play.api.mvc.HttpConnection.KeepAlive()));
}

/**
 * A simple Result which wraps a scala result so we can call it from our java controllers.
 */
private static class WrappedScalaResult implements Result {

    private play.api.mvc.Result scalaResult;

    public WrappedScalaResult(play.api.mvc.Result scalaResult) {
        this.scalaResult = scalaResult;
    }

    @Override
    public play.api.mvc.Result toScala() {
        return scalaResult;
    }

}