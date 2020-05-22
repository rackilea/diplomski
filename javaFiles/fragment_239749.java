package javaphp

import javax.script.ScriptEngineManager
import php.java.bridge._
import php.java.script._
import php.java.servlet._

object JVM{ // shared object for PHP/JVM communication
  var out = ""
  def put(s:String) = {
    out = s
  }
}

object Test extends App {
  val engine = (new ScriptEngineManager).getEngineByExtension("php")  
  val oldCode = """
    <?php
        function foo() {
            return 'hello';
            // some code that returns string
        }
    ?>
  """
  val newCode = """
    <?php
        $ans = foo();
        java('javaphp.JVM')->put($ans);
    ?>
  """+oldCode

  // below evaluates and returns
  JVM.out = "" //reset shared output
  engine.eval(newCode)
  println("output is : "+JVM.out) // prints hello
}