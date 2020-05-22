[microservice]> evicted
[info] Updating {file:/Users/jacek/work/.../}microservice...
[info] Resolving jline#jline;2.12 ...
[info] Done updating.
[warn] There may be incompatibilities among your library dependencies.
[warn] Here are some of the libraries that were evicted:
[warn]  * xml-apis:xml-apis:1.0.b2 -> 1.4.01 (caller: xerces:xercesImpl:2.11.0, dom4j:dom4j:1.6.1)
[warn]  * io.netty:netty:(3.6.6.Final, 3.6.3.Final) -> 3.9.3.Final (caller: com.typesafe.netty:netty-http-pipelining:1.1.2, com.typesafe.play:play_2.11:2.3.7, org.apache.cassandra:cassandra-all:2.0.8, com.netflix.astyanax:astyanax-cassandra:1.56.48)
[warn]  * joda-time:joda-time:1.6.2 -> 2.3 (caller: com.typesafe.play:play-json_2.11:2.3.7, com.netflix.astyanax:astyanax-core:1.56.48, com.typesafe.play:play_2.11:2.3.7, com.netflix.astyanax:astyanax-cassandra:1.56.48, com.netflix.astyanax:astyanax-recipes:1.56.48, com.netflix.astyanax:astyanax-thrift:1.56.48)
[warn]  * jline:jline:1.0 -> 2.11 (caller: com.tinkerpop:gremlin-groovy:3.0.0.M6, org.apache.cassandra:cassandra-all:2.0.8)
[success] Total time: 5 s, completed Feb 20, 2015 6:42:14 PM