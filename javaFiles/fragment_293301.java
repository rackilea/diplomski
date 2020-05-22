class NonSwipeableViewPager: ViewPager {

    init {
        setMyScroller()
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    private fun setMyScroller() {
        //some code
    }
}