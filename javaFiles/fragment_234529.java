[INFO ] -  - Parent start [            ] [parent] [              ] [main] 
[INFO ] -  - a start [            ] [a] [              ] [main] 
[INFO ] -  - HTTP exception handled [            ] [a] [              ] [main] 
[ERROR] -  - Failed delivery for (MessageId: ...). Exhausted after delivery attempt: 1 caught: null. Handled and continue routing.

Message History
---------------------------------------------------------------------------------------------------------------------------------------
RouteId              ProcessorId          Processor                                                                        Elapsed (ms)
[parent            ] [parent            ] [direct://parent                                                               ] [         8]
[parent            ] [log9              ] [log                                                                           ] [         0]
[parent            ] [to4               ] [direct:a                                                                      ] [         8]
[a                 ] [log7              ] [log                                                                           ] [         1]
[a                 ] [to3               ] [http4://localhost:8022/test/service?okStatusCodeRange=200-201                 ] [         8]
[                  ] [process2          ] [Processor@0x3c7f66c4                                                          ] [         8]
[a                 ] [log6              ] [log                                                                           ] [         1]
[a                 ] [setBody2          ] [setBody[{null}]                                                               ] [         0]

Stacktrace
--------------------------------------------------------------------------------------------------------------------------------------- [            ] [o.a.c.p.DefaultErrorHandler] [              ] [main] 
org.apache.camel.http.common.HttpOperationFailedException: HTTP operation failed invoking http://bla with statusCode: 204, redirectLocation: 
    at at.erpel.messaginghub.services.unit.routes.rest.Http4ExceptionHandlingTest$2.lambda$configure$1(Http4ExceptionHandlingTest.java:103)
    at org.apache.camel.processor.DelegateSyncProcessor.process(DelegateSyncProcessor.java:63)
    ...
[INFO ] -  - a done [            ] [a] [              ] [main] 
[INFO ] -  - Parent done [            ] [parent] [              ] [main]