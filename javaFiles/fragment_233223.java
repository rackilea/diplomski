[ouciance.random.MainApp.main()] DefaultCamelContext            INFO  Apache Camel 2.20.1 (CamelContext: camel-1) started in 1.696 seconds
[                 XNIO-1 task-1] B                              INFO  Exchange[
, Id: ID-moeed-Dator-1517066840557-0-3
, ExchangePattern: InOut
, Properties: {CamelCharsetName=ISO-8859-1, CamelCreatedTimestamp=Sat Jan 27 16:27:23 CET 2018, CamelExternalRedelivered=false, CamelMessageHistory=[DefaultMessageHistory[routeId=route2, node=route2], DefaultMessageHistory[routeId=route5, node=to4]], CamelToEndpoint=log://com.mycompany.B?multiline=true&showAll=true}
, Headers: {Accept-Encoding=gzip,deflate, breadcrumbId=ID-moeed-Dator-1517066840557-0-1, CamelHttpCharacterEncoding=ISO-8859-1, CamelHttpMethod=PUT, CamelHttpPath=, CamelHttpQuery=, CamelHttpRawQuery=, CamelHttpUri=/B/call, CamelHttpUrl=http://localhost:8080/B/call, Connection=Keep-Alive, Content-Length=23, Content-Type=application/json, firedTime=Sat Jan 27 16:27:23 CET 2018, Host=localhost:8080, User-Agent=Apache-HttpClient/4.5.3 (Java/1.8.0_71)}
, BodyType: String
, Body: {"hello":"hello"}
, Out: null: 
]
[                 XNIO-1 task-1] BeforeSendingToA               INFO  Exchange[
, Id: ID-moeed-Dator-1517066840557-0-3
, ExchangePattern: InOut
, Properties: {CamelCharsetName=ISO-8859-1, CamelCreatedTimestamp=Sat Jan 27 16:27:23 CET 2018, CamelExternalRedelivered=false, CamelMessageHistory=[DefaultMessageHistory[routeId=route2, node=route2], DefaultMessageHistory[routeId=route5, node=to4], DefaultMessageHistory[routeId=route5, node=marshal2], DefaultMessageHistory[routeId=route5, node=setHeader3], DefaultMessageHistory[routeId=route5, node=setHeader4], DefaultMessageHistory[routeId=route5, node=to5]], CamelToEndpoint=log://com.mycompany.BeforeSendingToA?multiline=true&showAll=true}
, Headers: {Accept-Encoding=gzip,deflate, breadcrumbId=ID-moeed-Dator-1517066840557-0-1, CamelHttpCharacterEncoding=ISO-8859-1, CamelHttpMethod=POST, CamelHttpPath=, CamelHttpQuery=, CamelHttpRawQuery=, CamelHttpUri=/B/call, CamelHttpUrl=http://localhost:8080/B/call, Connection=Keep-Alive, Content-Length=23, Content-Type=application/json, firedTime=Sat Jan 27 16:27:23 CET 2018, Host=localhost:8080, User-Agent=Apache-HttpClient/4.5.3 (Java/1.8.0_71)}
, BodyType: byte[]
, Body: "{\"hello\":\"hello\"}"
, Out: null: 
]
[l-1) thread #2 - seda://handle] handle                         INFO  Exchange[
, Id: ID-moeed-Dator-1517066840557-0-8
, ExchangePattern: InOut
, Properties: {CamelCharsetName=ISO-8859-1, CamelCorrelationId=ID-moeed-Dator-1517066840557-0-5, CamelCreatedTimestamp=Sat Jan 27 16:27:23 CET 2018, CamelExternalRedelivered=false, CamelMessageHistory=[DefaultMessageHistory[routeId=route1, node=route1], DefaultMessageHistory[routeId=route4, node=to2]], CamelToEndpoint=log://com.mycompany.handle?multiline=true&showAll=true}
, Headers: {Accept-Encoding=gzip,deflate, breadcrumbId=ID-moeed-Dator-1517066840557-0-1, CamelHttpCharacterEncoding=ISO-8859-1, CamelHttpMethod=POST, CamelHttpPath=, CamelHttpQuery=, CamelHttpRawQuery=, CamelHttpUri=/A/callResponse, CamelHttpUrl=http://localhost:8080/A/callResponse, Connection=Keep-Alive, Content-Length=23, Content-Type=application/json, firedTime=Sat Jan 27 16:27:23 CET 2018, Host=localhost:8080, User-Agent=Apache-HttpClient/4.5.3 (Java/1.8.0_71)}
, BodyType: String
, Body: {"hello":"hello"}
, Out: null: 
]
{"hello":"hello"}
[                 XNIO-1 task-1] AfterSendingToA                INFO  Exchange[
, Id: ID-moeed-Dator-1517066840557-0-3
, ExchangePattern: InOut
, Properties: {CamelCharsetName=UTF-8, CamelCreatedTimestamp=Sat Jan 27 16:27:23 CET 2018, CamelExternalRedelivered=false, CamelMessageHistory=[DefaultMessageHistory[routeId=route2, node=route2], DefaultMessageHistory[routeId=route5, node=to4], DefaultMessageHistory[routeId=route5, node=marshal2], DefaultMessageHistory[routeId=route5, node=setHeader3], DefaultMessageHistory[routeId=route5, node=setHeader4], DefaultMessageHistory[routeId=route5, node=to5], DefaultMessageHistory[routeId=route5, node=to6], DefaultMessageHistory[routeId=route5, node=to7]], CamelSkipGzipEncoding=true, CamelToEndpoint=log://com.mycompany.AfterSendingToA?multiline=true&showAll=true}
, Headers: {Accept-Encoding=gzip,deflate, breadcrumbId=ID-moeed-Dator-1517066840557-0-1, CamelHttpCharacterEncoding=ISO-8859-1, CamelHttpMethod=POST, CamelHttpPath=, CamelHttpQuery=, CamelHttpRawQuery=, CamelHttpResponseCode=200, CamelHttpResponseText=OK, CamelHttpUri=/B/call, CamelHttpUrl=http://localhost:8080/B/call, Connection=keep-alive, Content-Length=23, Content-Type=application/json, Date=Sat, 27 Jan 2018 15:27:23 GMT, firedTime=Sat Jan 27 16:27:23 CET 2018, User-Agent=Apache-HttpClient/4.5.3 (Java/1.8.0_71)}
, BodyType: org.apache.camel.converter.stream.CachedOutputStream.WrappedInputStream
, Body: [Body is instance of java.io.InputStream]
, Out: null: 
]