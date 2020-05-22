#!/bin/sh

REPOS="$1"
REV="$2"

/path/to/jdk/bin/javadoc -d ${REPOS}/myProject/target/javadoc -sourcepath "${REPOS}/myProject/src/main/java" -subpackages com