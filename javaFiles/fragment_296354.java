2018-06-27 09:00:32.754:INFO::main: Logging initialized @360ms to org.eclipse.jetty.util.log.StdErrLog
2018-06-27 09:00:32.898:INFO:oejs.Server:main: jetty-9.4.11.v20180605; built: 2018-06-05T18:24:03.829Z; git: d5fc0523cfa96bfebfbda19606cad384d772f04c; jvm 9.0.4+11
2018-06-27 09:00:32.969:INFO:oejsh.ContextHandler:main: Started o.e.j.s.ServletContextHandler@5dd6264{/,null,AVAILABLE}
2018-06-27 09:00:33.150:INFO:oejs.AbstractConnector:main: Started ServerConnector@60707857{HTTP/1.1,[http/1.1]}{0.0.0.0:9090}
2018-06-27 09:00:33.151:INFO:oejs.Server:main: Started @764ms

----
GET http://192.168.0.119:9090/demo HTTP/1.1
----
HTTP/1.1 200 OK
Server: Jetty(9.4.11.v20180605)
X-Charset: utf-8
Content-Length: 58
Date: Wed, 27 Jun 2018 14:00:33 GMT
Content-Type: application/json

{"mode":["a=b"],"animals":[["kiwi bird","kea","skink"]]}

2018-06-27 09:00:33.276:INFO:oejs.AbstractConnector:main: Stopped ServerConnector@60707857{HTTP/1.1,[http/1.1]}{0.0.0.0:9090}
2018-06-27 09:00:33.278:INFO:oejsh.ContextHandler:main: Stopped o.e.j.s.ServletContextHandler@5dd6264{/,null,UNAVAILABLE}