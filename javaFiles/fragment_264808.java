OutputStream os = message.getContent(OutputStream.class);
CachedStream cs = new CachedStream();
message.setContent(OutputStream.class, cs);

message.getInterceptorChain().doIntercept(message);

try {
    cs.flush();
    CachedOutputStream csnew = (CachedOutputStream) message.getContent(OutputStream.class);

    String soapMessage = IOUtils.toString(csnew.getInputStream());
    ...