$ mvn dependency:tree -DoutputType=dot | grep \> | cut -d\> -f2
 "org.apache.httpcomponents:httpclient:jar:4.5.5:compile" ; 
 "com.google.code.gson:gson:jar:2.8.2:compile" ; 
 "info.picocli:picocli:jar:2.3.0:compile" ; 
 "log4j:log4j:jar:1.2.17:compile" ; 
 "org.xerial:sqlite-jdbc:jar:3.21.0:compile" ; 
 "org.apache.httpcomponents:httpcore:jar:4.4.9:compile" ; 
 "commons-logging:commons-logging:jar:1.2:compile" ; 
 "commons-codec:commons-codec:jar:1.10:compile" ;