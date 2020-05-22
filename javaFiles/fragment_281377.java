val interval: Long = 1000
val statusChecker = object : Runnable {
    override fun run() {
        progressBar.progress = media.currentPosition
        handler.postDelayed(this, interval)
    }
}