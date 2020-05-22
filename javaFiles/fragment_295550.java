$ ls src/syntaxtest
NewClass.java
$ cat src/syntaxtest/NewClass.java
package syntaxtest;
public class NewClass {
  public static void main(String args[]) {
    System.out.println("Hello, World!");
  }
}
$ javac src/syntaxtest/NewClass.java
$ java -cp src syntaxtest.NewClass
Hello, World!