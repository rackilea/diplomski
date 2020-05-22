$ mvn dependency:tree | awk '/:tree/,/BUILD SUCCESS/' | awk 'NR > 2 { print }' | head -n -2
[INFO] +- org.apache.httpcomponents:httpclient:jar:4.5.5:compile
[INFO] |  +- org.apache.httpcomponents:httpcore:jar:4.4.9:compile
[INFO] |  +- commons-logging:commons-logging:jar:1.2:compile
[INFO] |  \- commons-codec:commons-codec:jar:1.10:compile
[INFO] +- com.google.code.gson:gson:jar:2.8.2:compile
[INFO] +- info.picocli:picocli:jar:2.3.0:compile
[INFO] +- log4j:log4j:jar:1.2.17:compile
[INFO] \- org.xerial:sqlite-jdbc:jar:3.21.0:compile