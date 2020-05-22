open class GifPlayer(private val listener: GifListener) {
        private val uiHandler = Handler(Looper.getMainLooper())
        private var playerHandlerThread: HandlerThread? = null
        private var playerHandler: Handler? = null
        private val gifDecoder: GifDecoder = GifDecoder()
        private var currentFrame: Int = -1
        var state: State = State.IDLE
            private set
        private val playRunnable: Runnable

        enum class State {
            IDLE, PAUSED, PLAYING, RECYCLED, ERROR
        }

        interface GifListener {
            fun onGotFrame(bitmap: Bitmap, frame: Int, frameCount: Int)

            fun onError()
        }

        init {
            playRunnable = object : Runnable {
                override fun run() {
                    val frameCount = gifDecoder.frameCount
                    gifDecoder.setCurIndex(currentFrame)
                    currentFrame = (currentFrame + 1) % frameCount
                    val bitmap = gifDecoder.bitmap
                    val delay = gifDecoder.decodeNextFrame().toLong()
                    uiHandler.post {
                        listener.onGotFrame(bitmap, currentFrame, frameCount)
                        if (state == State.PLAYING)
                            playerHandler!!.postDelayed(this, delay)
                    }
                }
            }
        }

        @Suppress("unused")
        protected fun finalize() {
            stop()
        }

        @UiThread
        fun start(filePath: String): Boolean {
            if (state != State.IDLE)
                return false
            currentFrame = -1
            state = State.PLAYING
            playerHandlerThread = HandlerThread("GifPlayer")
            playerHandlerThread!!.start()
            playerHandler = Handler(playerHandlerThread!!.looper)
            playerHandler!!.post {
                gifDecoder.load(filePath)
                val bitmap = gifDecoder.bitmap
                if (bitmap != null) {
                    playRunnable.run()
                } else {
                    gifDecoder.recycle()
                    uiHandler.post {
                        state = State.ERROR
                        listener.onError()
                    }
                    return@post
                }
            }
            return true
        }

        @UiThread
        fun stop(): Boolean {
            if (state == State.IDLE)
                return false
            state = State.IDLE
            playerHandler!!.removeCallbacks(playRunnable)
            playerHandlerThread!!.quit()
            playerHandlerThread = null
            playerHandler = null
            return true
        }

        @UiThread
        fun pause(): Boolean {
            if (state != State.PLAYING)
                return false
            state = State.PAUSED
            playerHandler?.removeCallbacks(playRunnable)
            return true
        }

        @UiThread
        fun resume(): Boolean {
            if (state != State.PAUSED)
                return false
            state = State.PLAYING
            playerHandler?.removeCallbacks(playRunnable)
            playRunnable.run()
            return true
        }

        @UiThread
        fun toggle(): Boolean {
            when (state) {
                State.PLAYING -> pause()
                State.PAUSED -> resume()
                else -> return false
            }
            return true
        }

    }