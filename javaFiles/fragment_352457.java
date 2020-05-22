#!/bin/bash

# directory of this script
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

mvn -o -f $DIR/pom.xml -q dependency:build-classpath -Dmdep.outputFile="$DIR/target/classpath.txt"

java -cp $DIR/target/classes:`cat $DIR/target/classpath.txt` example.Main $@
exitcode=$?
exit $exitcode