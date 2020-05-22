[[syntax trees at end of cleanup]]// Scala source: Test.scala
package <empty> {
  class Main extends java.lang.Object with ScalaObject {
    def test(x: java.lang.Object): Unit = {
      <synthetic> val temp1: java.lang.Object = x;
      if (temp1.==("Hello"))
        {
          scala.this.Predef.println("Hello World")
        }
      else
        if (temp1.$isInstanceOf[java.lang.String]())
          {
            scala.this.Predef.println("String")
          }
        else
          if (temp1.$isInstanceOf[Int]())
            {
              scala.this.Predef.println("Int")
            }
          else
            {
              scala.this.Predef.println("Something else")
            }
    };
    def this(): Main = {
      Main.super.this();
      ()
    }
  }
}