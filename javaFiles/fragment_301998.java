abstract class AbstractAnimatorListener : Animator.AnimatorListener {

    override fun onAnimationRepeat(p0: Animator?) {}

    override fun onAnimationEnd(p0: Animator?) {}

    override fun onAnimationCancel(p0: Animator?) {}

    override fun onAnimationStart(p0: Animator?) {}

    override fun onAnimationEnd(animation: Animator?, isReverse: Boolean) {
        onAnimationEnd(animation)
    }

    override fun onAnimationStart(animation: Animator?, isReverse: Boolean) {
        onAnimationStart(animation)
    }
}