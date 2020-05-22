$ ls .                   # Current directory contains the "x" package
x

$ ls x                   # The "x" package contains a Sample.java file...
Sample.java

$ cat x/Sample.java      # ...which looks like this.
package x;
public class Sample {
    public static void main(String... args) {
        System.out.println("Hello from Sample class");
    }
}

$ javac x/Sample.java    # Use "/" as delimiter and
                         # include the ".java"-suffix when compiling.

$ java x.Sample          # Use "." as delimiter when running, and don't include
                         # the ".class" suffix.
Hello from Sample class

$