import javax.script.ScriptEngineManager

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Main extends App {

  val logger: Logger = LoggerFactory.getLogger("main")

  val e = new ScriptEngineManager().getEngineByName("scala")
  e.put("a", 1)
  e.put("s", "String")

  // Since the variable will have a type of Object, inject under a different name, and then bind to the
  // "correct" name using eval.
  e.put("logInjected", logger)

  println(e.eval(""" s"a is $a, s is $s" """))
  println(e.eval(""" logInjected.toString """))

  e.eval(""" val log = logInjected.asInstanceOf[org.slf4j.Logger] """)
  e.eval(""" log.info("hello from injected logger") """)

  e.eval(
    """ // Or can you do this
      | import org.slf4j.Logger
      | import org.slf4j.LoggerFactory
      |
      | val l = LoggerFactory.getLogger("script")
      |
      | l.error("hello from script")
      |
      |""".stripMargin)
}