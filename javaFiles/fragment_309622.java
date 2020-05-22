import java.util.concurrent.CompletionStage
import java.util.function.BiConsumer
import com.twitter.util.{Future => TwitterFuture, Promise => TwitterPromise}

implicit class JavaCompletionStageTwitterOps[A](val jcs: CompletionStage[A]) extends AnyVal {
  def asTwitter(implicit e: ExecutionContext): TwitterFuture[A] = {
    val promise = new TwitterPromise[A] with BiConsumer[A, Throwable] {
      override def accept(value: A, ex: Throwable): Unit = {
        if (ex == null) this.setValue(value)
        else this.setException(ex)
      }
    }
    jcs.whenComplete(promise)
    promise
  }
}