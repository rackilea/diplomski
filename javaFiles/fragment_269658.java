$ cat Main.scala 
object Main {
  def main(args: Array[String]) = println("hello")
}
$ scalac Main.scala
$ ls *class
Main.class  Main$.class
$ javap -cp . Main
Compiled from "Main.scala"
public final class Main {
  public static void main(java.lang.String[]);
}
$ javap -cp . Main$
Compiled from "Main.scala"
public final class Main$ {
  public static final Main$ MODULE$;
  public static {};
  public void main(java.lang.String[]);
}
$ java -cp /usr/local/scala/lib/scala-library.jar:. Main
hello