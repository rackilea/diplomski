#!/bin/bash

program=`echo $1 | awk -F "." '{print $1}'`

if [ ! -d "${program}_classes" ]
    then    mkdir ${program}_classes/;
fi

javac -classpath /usr/lib/hadoop/hadoop-common-2.0.0-cdh4.0.1.jar:/usr/lib/hadoop/client/h\
adoop-mapreduce-client-core-2.0.0-cdh4.0.1.jar -d ${program}_classes/ $1

jar -cvf ${program}.jar -C ${program}_classes/ .;