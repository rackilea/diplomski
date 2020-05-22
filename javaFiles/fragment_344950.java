class VideoLiveWallpaperService : WallpaperService() {

    override fun onCreateEngine(): WallpaperService.Engine {
        return VideoEngine()
    }

    internal inner class VideoEngine : WallpaperService.Engine() {

        private val TAG = javaClass.simpleName
        private val mediaPlayer: MediaPlayer

        init {
            Log.i(TAG, "( VideoEngine )")
            mediaPlayer = MediaPlayer.create(baseContext, R.raw.video1)
            mediaPlayer.isLooping = true
        }

        override fun onSurfaceCreated(holder: SurfaceHolder) {
            Log.i(TAG, "onSurfaceCreated")
            mediaPlayer.setSurface(holder.surface)
            mediaPlayer.start()
        }

        override fun onSurfaceDestroyed(holder: SurfaceHolder) {
            Log.i(TAG, "( INativeWallpaperEngine ): onSurfaceDestroyed")
            playheadTime = mediaPlayer.currentPosition
            mediaPlayer.reset()
            mediaPlayer.release()
        }
    }

    companion object {
        protected var playheadTime = 0
    }

}