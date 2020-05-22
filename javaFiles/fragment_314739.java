val guideline = findViewById<View>(R.id.guideline2) as Guideline
    val end = (guideline.layoutParams as ConstraintLayout.LayoutParams).guidePercent
    // get end percent. start at 0
    val valueAnimator = ValueAnimator.ofFloat(0f, end)
    valueAnimator.duration = 3000
    // set duration 
    valueAnimator.interpolator = AccelerateDecelerateInterpolator()
    // set interpolator and  updateListener to get the animated value
    valueAnimator.addUpdateListener { valueAnimator ->
        val lp = guideline.layoutParams as ConstraintLayout.LayoutParams
        // get the float value
        lp.guidePercent = valueAnimator.animatedValue as Float
        // update layout params
        guideline.layoutParams = lp
    }
    valueAnimator.start()