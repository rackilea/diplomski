inline fun View.animateTranslationY(translationY: Float, duration: Long = 1000, startDelay: Long = 0) {
    val translationYAnimator = ObjectAnimator.ofFloat(this, "translationY", translationY)
    translationYAnimator.duration = duration
    translationYAnimator.startDelay = startDelay
    translationYAnimator.interpolator = LinearInterpolator()
    translationYAnimator.addAnimatorListener(
            onStart = { },
            onEnd = { }
    )
    translationYAnimator.start()
}