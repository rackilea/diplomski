$ cat Foo.java 
public class Foo {
     public void tryit() {
         try {
             File f = new File(null);
         }
     }
}
$ javac Foo.java
Foo.java:3: 'try' without 'catch' or 'finally'
         try {
         ^
1 error
$