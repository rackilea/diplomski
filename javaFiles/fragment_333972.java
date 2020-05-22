val imageXAnimator = ObjectAnimator.ofFloat(imageView, "translationX", translateX)
val imageYAnimator = ObjectAnimator.ofFloat(imageView, "translationY", translateY)
val imageAlphaAnimator = ObjectAnimator.ofFloat(imageView, "alpha", if (reverse) 0F else 1F)

val animationSet = AnimatorSet()
        animationSet.playTogether(
                imageXAnimator,
                imageYAnimator,
                imageAlphaAnimator)
        animationSet.interpolator = DecelerateInterpolator()
        animationSet.duration = 1000
        animationSet.addListener(
            onStart = {
                //When animation is started
            },
            onEnd = {
                //When animation finishes
            }
        )
        animationSet.start()