Jetty Environment:
-----------------
 jetty.version = 9.4.3.v20170317
 jetty.tag.version = master
 jetty.home = /opt/prod-server/nm_jetty/jetty-9.4.3
 jetty.base = /opt/prod-server/nm_jetty/roy-comp-jetty/.

Config Search Order:
--------------------
 <command-line>
 ${jetty.base} -> /opt/prod-server/nm_jetty/roy-comp-jetty/.
 ${jetty.home} -> /opt/prod-server/nm_jetty/jetty-9.4.3


JVM Arguments:
--------------
 -Dorg.eclipse.jetty.util.log.class?=org.eclipse.jetty.util.log.Slf4jLog

System Properties:
------------------
 STOP.KEY = stop-roy-comp
 STOP.PORT = 15041
 conf.dir = .
 jetty.base = .

Properties:
-----------
 STOP.KEY = stop-roy-comp
 STOP.PORT = 15041
 conf.dir = .
 java.version = 1.8.0_65
 java.version.major = 1
 java.version.micro = 0
 java.version.minor = 8
 java.version.platform = 8
 java.version.update = 65
 jetty.base = /opt/prod-server/nm_jetty/roy-comp-jetty/.
 jetty.http.port = 15040
 jetty.webapp.addServerClasses = ${jetty.base.uri}/lib/slf4j/,${jetty.base.uri}/lib/logback/
 logback.version = 1.1.7
 slf4j.version = 1.7.21