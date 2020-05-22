val animator = ObjectAnimator.ofFloat(yourView, "rotation", 0f, 360f).apply {
    duration = 5000
    repeatCount = ObjectAnimator.INFINITE
    start()
}
// ...
animator.pause()