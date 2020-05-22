#!/bin/sh
# build all other dependent jars in OTHER_JARS

JARS=`find ../lib -name '*.jar'`
OTHER_JARS=""
   for eachjarinlib in $JARS ; do    
if [ "$eachjarinlib" != "APPLICATIONJARTOBEADDEDSEPERATELY.JAR" ]; then
       OTHER_JARS=$eachjarinlib,$OTHER_JARS
fi
done
echo ---final list of jars are : $OTHER_JARS
echo $CLASSPATH

spark-submit --verbose --class <yourclass>
... OTHER OPTIONS
--jars $OTHER_JARS,APPLICATIONJARTOBEADDEDSEPERATELY.JAR