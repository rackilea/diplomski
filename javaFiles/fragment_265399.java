(private val context: Context, statusText: TextView) : AsyncTask<Void, Void, String>() {
    private val isname = true
    private val name = "啦啦啦"
    private val statusText: TextView
    internal var myhandler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                10 -> statusText.text = "XXXXXX"
            }
        }
    }

    init {
        this.statusText = statusText as TextView
    }

    override fun doInBackground(vararg params: Void): String? {
        return null
    }
}