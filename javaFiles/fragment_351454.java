apm@mara:~/tmp/bigmethod$ skalac bigmethod.scala ; skalac -J-Xss2m biguser.scala ; skala bigmethod.Test
Error is java.lang.RuntimeException: Method code too large!
Error is java.lang.RuntimeException: Method code too large!
biguser.scala:5: error: You ask too much of me.
  Console println s"5 => ${BigMethod.lookup(5)}"
                                           ^
one error found