JAVA_HOME=$(readlink -f /usr/bin/javac | sed "s:bin/javac::")
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:.
javac GetThreadID.java
javah GetThreadID

gcc -I${JAVA_HOME}/include -fPIC -shared GetThreadID.c -o libGetThreadID.so
javac Main.java
java Main