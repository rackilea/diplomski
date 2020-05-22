2018-03-27 07:03:25.220:INFO::main: Logging initialized @320ms to org.eclipse.jetty.util.log.StdErrLog
2018-03-27 07:03:25.288:INFO:oejs.Server:main: jetty-9.4.9.v20180320; built: 2018-03-20T07:21:10-05:00; git: 1f8159b1e4a42d3f79997021ea1609f2fbac6de5; jvm 9.0.4+11
2018-03-27 07:03:25.309:INFO:oejs.AbstractConnector:main: Started LocalConnector@4ba2ca36{HTTP/1.1,[http/1.1]}
2018-03-27 07:03:25.310:INFO:oejs.Server:main: Started @417ms
MyErrorHandler.handle() - DispatcherType: REQUEST
MyRequestHandler.handle() - DispatcherType: REQUEST
request body: hi
2018-03-27 07:03:25.399:WARN:oejs.HttpChannel:qtp525571-15: /
java.lang.NullPointerException
    at jetty.errors.HandlerWithError$MyRequestHandler.handle(HandlerWithError.java:41)
    at org.eclipse.jetty.server.handler.HandlerList.handle(HandlerList.java:61)
    at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:132)
    at org.eclipse.jetty.server.Server.handle(Server.java:531)
    at org.eclipse.jetty.server.HttpChannel.handle(HttpChannel.java:352)
    at org.eclipse.jetty.server.HttpConnection.onFillable(HttpConnection.java:260)
    at org.eclipse.jetty.io.AbstractConnection$ReadCallback.succeeded(AbstractConnection.java:281)
    at org.eclipse.jetty.io.FillInterest.fillable(FillInterest.java:102)
    at org.eclipse.jetty.io.ByteArrayEndPoint$1.run(ByteArrayEndPoint.java:78)
    at org.eclipse.jetty.util.thread.QueuedThreadPool.runJob(QueuedThreadPool.java:754)
    at org.eclipse.jetty.util.thread.QueuedThreadPool$2.run(QueuedThreadPool.java:672)
    at java.base/java.lang.Thread.run(Thread.java:844)
MyErrorHandler.handle() - DispatcherType: ERROR
Response: HTTP/1.1 503 Service Unavailable
Connection: close
Content-Type: text/plain;charset=ISO-8859-1
Content-Length: 29
Server: Jetty(9.4.9.v20180320)

Go away, you silly NPE fool

2018-03-27 07:03:25.423:INFO:oejs.AbstractConnector:main: Stopped LocalConnector@4ba2ca36{HTTP/1.1,[http/1.1]}