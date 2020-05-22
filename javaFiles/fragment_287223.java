lazy val runJnaerator= taskKey[Unit]("This task generates libraries from native code")

runJnaerator := {
    import sys.process._
    Seq("java" , "-jar", "jnaerator", "..." ).!
}