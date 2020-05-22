# check if running Oracle JDK 7, warn if not
 checkjvmcompatibility() {
+  echo $JAVACMD
+  $JAVACMD -version
   $JAVACMD -version 2>&1 | egrep -q "Java HotSpot\\(TM\\) (64-Bit Server|Server|C
 lient) VM"
   if [ $? -eq 1 ]
   then
     echo "WARNING! You are using an unsupported Java runtime. Please use Oracle(R) Java(TM) Runtime Environment 7."
   else
     $JAVACMD -version 2>&1 | egrep -q "java version \"1.7"
     if [ $? -eq 1 ]
     then
       echo "WARNING! You are using an unsupported version of the Java runtime. Please use Oracle(R) Java(TM) Runtime Environment 7."
     fi
   fi
 }