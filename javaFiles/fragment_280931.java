#!/bin/bash

scriptPos=${0%/*}

# This is a workaround script for a bug in the OpenJDK backport on Ubuntu.
# Bug causes problems in the Surefire plugin.
# https://issues.apache.org/jira/browse/SUREFIRE-1588
# https://stackoverflow.com/questions/53010200/maven-surefire-could-not-find-forkedbooter-class

_JAVA_OPTIONS=-Djdk.net.URLClassPath.disableClassPathURLCheck=true mvn $@