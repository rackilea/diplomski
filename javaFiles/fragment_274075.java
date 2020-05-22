> javac *.java
> c++ -g -shared -fpic -I${JAVA_HOME}/include \
-I${JAVA_HOME}/include/darwin \
NativeCppAdapter.cpp \
-o /tmp/libNativeCppAdapter.so
> java -cp . Main
Hello from Java main!
Correct kickoff of Native JNI method nr. 1