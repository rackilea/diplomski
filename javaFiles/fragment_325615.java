~$ java -ea -classpath /home/admin Boo
Exception in thread "main" java.lang.AssertionError: some text
at Boo.main(Boo.java:7)
~$ cat Boo.java 

public class Boo {

public static void main(String[] args) {

int i =100;
  assert i < 99 : "some text" ;

} 

}