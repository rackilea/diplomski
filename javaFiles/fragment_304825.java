set CLASSPATH=
mkdir bin1 bin2
javac -d bin1 -sourcepath src1 src1\com\stack\Test.java
javac -d bin2 -sourcepath src2 src2\com\stack\Test\Example\Cow\Hoof.java

set CLASSPATH=bin1;bin2
java com.stack.Test