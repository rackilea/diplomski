// custom extension function for handler
inline fun Handler.postDelayed(delayMilis: Long, crossinline runnable: (Runnable) -> Unit) = postDelayed(object : Runnable{
    override fun run() {
        runnable(this)
    }
}, delayMilis)