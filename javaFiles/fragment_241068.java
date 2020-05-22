$ mvn dependency:tree | awk '/:tree/,/BUILD SUCCESS/' | awk 'NR > 2 { print }' | head -n -2 | grep -o -P '.*(?<=:).*(?=:jar)' | sed -e 's/\(- \).*\(:\)/\1\2/' | tr -d :
[INFO] +- httpclient
[INFO] |  +- httpcore
[INFO] |  +- commons-logging
[INFO] |  \- commons-codec
[INFO] +- gson
[INFO] +- picocli
[INFO] +- log4j
[INFO] \- sqlite-jdbc