fun View.animateFadeOut(animDuration: Long = 250L) {
    this.animate()
            .alpha(0F)
            .setDuration(animDuration)
            .setListener(object : AbstractAnimatorListener() {

                override fun onAnimationEnd(animation: Animator?, isReverse: Boolean) {
                    super.onAnimationEnd(animation, isReverse)
                    show(false)
                }

                override fun onAnimationEnd(p0: Animator?) {
                    show(false)
                }
            })
            .start()
}

fun View.show(show: Boolean) {
    val vis = if (show) View.VISIBLE else View.GONE
    if (visibility != vis) {
        visibility = vis
    }
}