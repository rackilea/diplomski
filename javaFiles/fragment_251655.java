#!/bin/bash

ERROR="error:"

java -version 2>&1 | grep -i icedtea > /dev/null
if [ $? -eq 0 ]; then
   ERROR="error:\|errors\|.java:"
fi

javac *.java 2>&1 | grep -A 4 $ERROR