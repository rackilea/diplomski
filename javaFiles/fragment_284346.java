Glide.with(mContext)
    .load(imageUrl)
    .animate(R.anim.abc_fade_in)
    .signature(new StringSignature(String.valueOf(System.currentTimeMillis())))
    .centerCrop()
    .into(mImageView_photo)
;