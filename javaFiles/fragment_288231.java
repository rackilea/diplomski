class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    lateinit var countDownTimer:CountDownTimer
    var currentOffsetx = 0
    var textWidth = 0
    var isIncrease = true
    lateinit var txt:AKChangeColorTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        (findViewById<View>(R.id.tv_hello) as AKChangeColorTextView).apply{
            txt = this
        }

        countDownTimer = object:CountDownTimer(300000,200){
            override fun onFinish() {
            }

            override fun onTick(millisUntilFinished: Long) {
                if (textWidth == 0) {
                    textWidth = txt.width
                }
                if (currentOffsetx <= textWidth) {
                    if (isIncrease) {
                        currentOffsetx += 10
                        currentOffsetx = min(currentOffsetx, textWidth)
                    } else {
                        currentOffsetx -= 10
                        currentOffsetx = max(currentOffsetx, 0)
                    }
                }
                if (currentOffsetx == textWidth) {
                    isIncrease = false
                }else if (currentOffsetx == 0) {
                    isIncrease = true
                }
                txt.setXOffset(0f,currentOffsetx.toFloat())
                Log.w(TAG,"check current tick:$millisUntilFinished,offsetx:$currentOffsetx,txtWidth:$textWidth")
            }
        }
        countDownTimer.start()
    }

}