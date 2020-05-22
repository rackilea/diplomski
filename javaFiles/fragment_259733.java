Glide.with(activity)
    .load("...")
    .listener(object : RequestListener<String, GlideDrawable> {
        override fun onResourceReady(resource: GlideDrawable?, model: String?, target: Target<GlideDrawable>?, isFromMemoryCache: Boolean, isFirstResource: Boolean): Boolean {

            // GlideDrawable extends Drawable :)
        }

        override fun onException(e: Exception?, model: String?, target: Target<GlideDrawable>?, isFirstResource: Boolean): Boolean = false
    })