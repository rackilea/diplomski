$ mvn dependency:tree | awk '/:tree/,/BUILD SUCCESS/' | awk 'NR > 2 { print }' | head -n -2 | grep -o -P '.*(?<=:).*(?=:jar)'
[INFO] +- org.apache.httpcomponents:httpclient
[INFO] |  +- org.apache.httpcomponents:httpcore
[INFO] |  +- commons-logging:commons-logging
[INFO] |  \- commons-codec:commons-codec
[INFO] +- com.google.code.gson:gson
[INFO] +- info.picocli:picocli
[INFO] +- log4j:log4j
[INFO] \- org.xerial:sqlite-jdbc