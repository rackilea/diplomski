class MyWeb@JvmOverloads constructor(
context: Context,
attrs: AttributeSet? = null,
defStyleAttr: Int = 0) : WebView(context, attrs, defStyleAttr) {

override fun onCreateInputConnection(outAttrs: EditorInfo): InputConnection {
    val inputConnection = BaseInputConnection(this, false)
    return inputConnection
}

override fun dispatchKeyEvent(event: KeyEvent): Boolean {
    super.dispatchKeyEvent(event)
    val dispatchFirst = super.dispatchKeyEvent(event)
    if (event.action == KeyEvent.ACTION_UP) {
        when (event.keyCode) {
            KeyEvent.KEYCODE_ENTER -> {
                Toast.makeText(context,"Hii",Toast.LENGTH_LONG).show()
                //callback?.onEnter()
            }
        }
    }
    return dispatchFirst
}