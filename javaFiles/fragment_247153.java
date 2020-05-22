scala> :paste
// Entering paste mode (ctrl-D to finish)

object A { def B(a: Int) = "foo" }
object B 
import A._
B(4)

// Exiting paste mode, now interpreting.

<pastie>:41: error: B.type does not take parameters
       B(4)
        ^