HttpTransportMetricsImpl metrics = new HttpTransportMetricsImpl();
SessionOutputBufferImpl sob = new SessionOutputBufferImpl(metrics, 1024);
sob.bind(_os);//writes to this buffer go to the output stream/socket
DefaultHttpResponseWriter responseWriter = new DefaultHttpResponseWriter(sob);
responseWriter.write(resp);
StrictContentLengthStrategy contentLengthStrategy = new StrictContentLengthStrategy();
long len = contentLengthStrategy.determineLength(resp);
OutputStream outputStream;
if (len == ContentLengthStrategy.CHUNKED) {
    outputStream = new ChunkedOutputStream(2048, sob);
} else if (len == ContentLengthStrategy.IDENTITY) {
    outputStream = new IdentityOutputStream(sob);
} else {
    outputStream = new ContentLengthOutputStream(sob, len);
}
if (null != resp.getEntity()) {
    resp.getEntity().writeTo(outputStream);
}
// Must be closed, especially when using chunk coding 
// in order to generate a closing chunk
outputStream.close();
sob.flush();