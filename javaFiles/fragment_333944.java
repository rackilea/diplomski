all: Main.class main

Main.class: Main.java
    javac Main.java

main.o: main.c
    llvm-gcc -c main.c \
    -I${JAVA_HOME}/include \
    -I${JAVA_HOME}/include/darwin/ \

main: main.o
    ld -o main -L${JAVA_HOME}/jre/lib/server/ \
        -ljvm \
    -rpath ${JAVA_HOME}/jre/lib/server \
    -L/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.12.sdk \
    -demangle -dynamic -arch x86_64 \
    -macosx_version_min 10.12.0 \
    -lSystem \
    -rpath ${JAVA_HOME}/jre/lib/server/ \
    main.o

clean:
    rm -f Main.class main main.o