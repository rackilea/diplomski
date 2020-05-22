import scala.concurrent.ops._
import com.twitter.conversions.time._
import com.twitter.util.{Future,Promise}

val p = new Promise[String]
val longOp = (s: String) => { 
  val p = new Promise[String]
  spawn { Thread.sleep(5000); p.setValue("Received: " + s) }
  p 
}
val both = p flatMap longOp
both.get(1 second)  // p is not complete, so longOp hasn't been called yet, so this will fail
p.setValue("test")  // we set p, but we have to wait for longOp to complete
both.get(1 second)  // this fails because longOp isn't done
both.get(5 seconds)  // this will succeed