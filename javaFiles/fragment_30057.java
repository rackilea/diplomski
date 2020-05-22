java
    -javaagent:.\libs\aspectjweaver-1.7.3.jar 
    -Xbootclasspath/p:libs/aspectjweaver-1.7.3.jar;libs/aspectjrt-1.7.3.jar 
    -cp ".\libs\ProtoApp-v0.0.1-SNAPSHOT.jar;.\libs\*" 
    -Xms64m -Xmx512m -XX:MaxPermSize=128m 
    -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=7777 
    -Dcom.sun.management.jmxremote.authenticate=false 
    -Dcom.sun.management.jmxremote.ssl=false 
    -Daj.weaving.verbose=true -Dorg.aspectj.weaver.showWeaveInfo=true 
    -Dlogback.configurationFile=file:.\logback.xml 
    org.iiter.continuum.protos.simple.App