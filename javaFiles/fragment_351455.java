apm@mara:~/tmp/bigmethod$ skalac -J-Xss1m biguser.scala 
Error is java.lang.StackOverflowError
Error is java.lang.StackOverflowError
biguser.scala:5: error: You ask too much of me.
  Console println s"5 => ${BigMethod.lookup(5)}"
                                           ^