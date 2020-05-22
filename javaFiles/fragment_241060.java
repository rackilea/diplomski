$ mvn dependency:tree -DoutputType=dot
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building test 1.0
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-dependency-plugin:2.8:tree (default-cli) @ test ---
[INFO] digraph "com.a:test:jar:1.0" { 
[INFO]  "com.a:test:jar:1.0" -> "org.apache.httpcomponents:httpclient:jar:4.5.5:compile" ; 
[INFO]  "com.a:test:jar:1.0" -> "com.google.code.gson:gson:jar:2.8.2:compile" ; 
[INFO]  "com.a:test:jar:1.0" -> "info.picocli:picocli:jar:2.3.0:compile" ; 
[INFO]  "com.a:test:jar:1.0" -> "log4j:log4j:jar:1.2.17:compile" ; 
[INFO]  "com.a:test:jar:1.0" -> "org.xerial:sqlite-jdbc:jar:3.21.0:compile" ; 
[INFO]  "org.apache.httpcomponents:httpclient:jar:4.5.5:compile" -> "org.apache.httpcomponents:httpcore:jar:4.4.9:compile" ; 
[INFO]  "org.apache.httpcomponents:httpclient:jar:4.5.5:compile" -> "commons-logging:commons-logging:jar:1.2:compile" ; 
[INFO]  "org.apache.httpcomponents:httpclient:jar:4.5.5:compile" -> "commons-codec:commons-codec:jar:1.10:compile" ; 
[INFO]  } 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.215 s
[INFO] Finished at: 2018-03-27T17:58:31+03:00
[INFO] Final Memory: 14M/303M
[INFO] ------------------------------------------------------------------------