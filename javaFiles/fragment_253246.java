val options = RequestOptions()
    .format(DecodeFormat.PREFER_RGB_565)
    .placeholder(R.drawable.ic_placeholder)
    .error(R.drawable.ic_error)

Glide.with(this)
     .setDefaultRequestOptions(options)
     .load(campaign!!.imageURL)
     .centerInside()
     .into(object : CustomTarget<Drawable>(width, height) {
         override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
              imagePort.setImageDrawable(resource)
         }

        override fun onLoadCleared(placeholder: Drawable?) {

        }
     })