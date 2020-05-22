$ mvn dependency:tree -DoutputType=dot | grep \>
[INFO]  "com.a:test:jar:1.0" -> "org.apache.httpcomponents:httpclient:jar:4.5.5:compile" ; 
[INFO]  "com.a:test:jar:1.0" -> "com.google.code.gson:gson:jar:2.8.2:compile" ; 
[INFO]  "com.a:test:jar:1.0" -> "info.picocli:picocli:jar:2.3.0:compile" ; 
[INFO]  "com.a:test:jar:1.0" -> "log4j:log4j:jar:1.2.17:compile" ; 
[INFO]  "com.a:test:jar:1.0" -> "org.xerial:sqlite-jdbc:jar:3.21.0:compile" ; 
[INFO]  "org.apache.httpcomponents:httpclient:jar:4.5.5:compile" -> "org.apache.httpcomponents:httpcore:jar:4.4.9:compile" ; 
[INFO]  "org.apache.httpcomponents:httpclient:jar:4.5.5:compile" -> "commons-logging:commons-logging:jar:1.2:compile" ; 
[INFO]  "org.apache.httpcomponents:httpclient:jar:4.5.5:compile" -> "commons-codec:commons-codec:jar:1.10:compile" ;