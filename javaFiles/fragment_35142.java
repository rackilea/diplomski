private object DefaultErrorHandler : Consumer<Throwable> {
  override fun accept(t: Throwable) {
    when (t) {
        is UndeliverableException -> accept(t.cause!!)
        is NullPointerException,
        is IllegalArgumentException -> Thread.currentThread().run {
            uncaughtExceptionHandler.uncaughtException(this, t)
        }
        else -> // Swallow the exception here. We logged it to Crashlytics...
    }
  }
}

val defaultErrorHandler: Consumer<Throwable> = DefaultErrorHandler

// Then on application start we would replace the error handler
RxJavaPlugins.setErrorHandler(defaultErrorHandler)