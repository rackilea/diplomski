2018-03-27 06:47:40.074:INFO::main: Logging initialized @429ms to org.eclipse.jetty.util.log.StdErrLog
2018-03-27 06:47:40.148:INFO:oejs.Server:main: jetty-9.4.9.v20180320; built: 2018-03-20T07:21:10-05:00; git: 1f8159b1e4a42d3f79997021ea1609f2fbac6de5; jvm 9.0.4+11
2018-03-27 06:47:40.182:INFO:oejs.AbstractConnector:main: Started LocalConnector@2f490758{HTTP/1.1,[http/1.1]}
2018-03-27 06:47:40.183:INFO:oejs.Server:main: Started @548ms
2018-03-27 06:47:40.287:WARN:oejs.HttpChannel:qtp2104545713-16: /
java.lang.NullPointerException
    at jetty.errors.HandlerWithError.handle(HandlerWithError.java:29)
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
request body: hi
Now in DispatchType: ERROR