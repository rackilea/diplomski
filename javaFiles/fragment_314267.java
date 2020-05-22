class GifPlayer(private val listener: GifListener) : Runnable {
    private var playThread: Thread? = null
    private val gifDecoder: GifDecoder = GifDecoder()
    private var sourceType: SourceType? = null
    private var filePath: String? = null
    private var sourceBuffer: ByteArray? = null
    private var isPlaying = AtomicBoolean(false)

    interface GifListener {
        fun onGotFrame(bitmap: Bitmap, frame: Int, frameCount: Int)

        fun onError()
    }

    @UiThread
    fun setFilePath(filePath: String) {
        sourceType = SourceType.SOURCE_PATH
        this.filePath = filePath
    }

    @UiThread
    fun setBuffer(buffer: ByteArray) {
        sourceType = SourceType.SOURCE_BUFFER
        sourceBuffer = buffer
    }

    @UiThread
    fun start() {
        if (sourceType != null) {
            playThread = Thread(this)
            synchronized(this) {
                isPlaying.set(true)
            }
            playThread!!.start()
        }
    }

    @UiThread
    fun stop() {
        playThread?.interrupt()
    }

    @UiThread
    fun pause() {
        synchronized(this) {
            isPlaying.set(false)
            (this as java.lang.Object).notify()
        }
    }

    @UiThread
    fun resume() {
        synchronized(this) {
            isPlaying.set(true)
            (this as java.lang.Object).notify()
        }
    }

    @UiThread
    fun toggle() {
        synchronized(this) {
            isPlaying.set(!isPlaying.get())
            (this as java.lang.Object).notify()
        }
    }

    override fun run() {
        try {
            val isLoadOk: Boolean = if (sourceType == SourceType.SOURCE_PATH) {
                gifDecoder.load(filePath)
            } else {
                gifDecoder.load(sourceBuffer)
            }
            val bitmap = gifDecoder.bitmap
            if (!isLoadOk || bitmap == null) {
                listener.onError()
                gifDecoder.recycle()
                return
            }
            var i = -1
            val frameCount = gifDecoder.frameCount
            gifDecoder.setCurIndex(i)
            while (true) {
                if (isPlaying.get()) {
                    val delay = gifDecoder.decodeNextFrame()
                    Thread.sleep(delay.toLong())
                    i = (i + 1) % frameCount
                    listener.onGotFrame(bitmap, i, frameCount)
                } else {
                    synchronized(this@GifPlayer) {
                        if (!isPlaying.get())
                            (this@GifPlayer as java.lang.Object).wait()
                    }
                }
            }
        } catch (interrupted: InterruptedException) {
        } catch (e: Exception) {
            e.printStackTrace()
            listener.onError()
        } finally {
        }
    }


    internal enum class SourceType {
        SOURCE_PATH, SOURCE_BUFFER
    }

}