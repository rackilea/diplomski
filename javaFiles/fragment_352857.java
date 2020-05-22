#!/bin/sh
mvn clean;
for i in {1..5}
do
    echo "botnumber=$i" > ./src/main/resources/bottest.properties;
    mvn install -Dmaven.test.skip;
    cp target/bottest-1.0-SNAPSHOT.jar target/bootest$i.jar
done