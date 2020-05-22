#!/bin/bash
#--------------------------------------------------------------------
# Simple multi-MFP launcher script
# Karl Bishop <kfbishop@us.ibm.com>
#--------------------------------------------------------------------

#-- Set specific Java Runtime?
#export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0.jdk/Contents/Home
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_55.jdk/Contents/Home

#-- MFP Home directory for custom runtimes
MFP_HOME="${HOME}/dev/mobilefirst"

#-- Set specific Java Runtime
export PATH=$JAVA_HOME/bin:$PATH
echo "Using Java: ${JAVA_HOME}"

#-- Launch custom MFP
${MFP_HOME}/mobilefirst-cli/bin/mobilefirst-cli.js $@