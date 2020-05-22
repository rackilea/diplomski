#Variables
JAVA=$HOME/algs4

#Set $CLASSPATH
if [ -d $JAVA ]; then
        export CLASSPATH=.:$JAVA/stdlib.jar:$JAVA/algs4.jar
fi