val future: Future<Any> = ask(sender, MyActor.Greeting("Saeed"), 5000)

future.onComplete(object : OnComplete<Any?>() {
    override fun onComplete(failure: Throwable?, success: Any?) {
        throw UnsupportedOperationException()
    }
}, context.dispatcher())