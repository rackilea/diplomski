GlideApp.with(getContext())
            .asGif()
            .load(R.raw. my_gif_animation)
            .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
            .listener(object : RequestListener<GifDrawable> {

                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any,
                    target: Target<GifDrawable>,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: GifDrawable?,
                    model: Any,
                    target: Target<GifDrawable>,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    myThread = Thread(Runnable {
                        while (true) {
                            if (resource?.isRunning == true) {
                                if (resource.frameIndex == 10).toInt()) {
                                    // This code will be executed every time the 10th frame of the GIF animation is played.. 
                                }
                                if (Thread.interrupted()) break
                            }
                        }
                    })
                    myThread?.start()
                    return false
                }
            })
            .into(this)