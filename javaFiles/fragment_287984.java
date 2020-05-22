class TouchInterceptorLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    // You need override this method.
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return true
    }
}