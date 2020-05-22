%pre
  # try to find jvm from java command

  # try javac first, or we might get the location of the jre instead - djw
  java=`which javac 2>/dev/null || :`

  # if we don't have the jdk, then maybe we have the jre - djw
  if [ -z "$java" ] ; then
    java=`which java 2>/dev/null || :`
  fi

  if [ -n "$java" ] ; then
    while [ -h "$java" ] ; do
      java=`readlink $java 2>/dev/null`
    done
    return
  fi

  echo "Can't find java virtual machine, aborting."
  exit 1