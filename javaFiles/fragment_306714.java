#!/bin/sh

TEMPFILE=`mktemp`
while true ; do
  echo "`date` Starting application" >> $TEMPFILE
  java -XX:OnOutOfMemoryError="kill -9 %p" -jar application.jar
  sleep 5
done