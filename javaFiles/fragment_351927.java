#!/bin/bash

# Resources:
# http://stackoverflow.com/questions/623518
# http://stackoverflow.com/questions/59895
# http://markashleybell.com/articles/portable-git-windows-setting-home-environment-variable

# Get the directory this script is in:
DIR=$(cd $(dirname "$0"); pwd)
# Get only the Flash-Drive letter (e.g. "F")
FLASH=${DIR:1:1}
echo "We determined your USB-drive to be on $FLASH:\\"
# Set the home-path to the Flash-drive to get portable SSH-keys:
# --- You'll want to change this to your prefered Home-directory!
export HOME=/$FLASH/PortableApps/git/home/luke
echo "I set your Home-directory to '$HOME'";

### --- EXAMPLES ---

# Set the Java-Home variable to a JDK on USB-Stick:
export JAVA_HOME=/$FLASH/JDK1.6
# Add the Java-Tools to the JDK-folder:
export PATH=$PATH:/$FLASH/JDK1.6/bin

# Add a Maven from your USB-drive to the PATH:
export PATH=$PATH:/$FLASH/PortableApps/apache-maven/bin

# Add Node.js from the local pc to your PATH:
export PATH=$PATH:/c/Programms/nodejs