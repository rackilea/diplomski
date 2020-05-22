class MainActivity : AppCompatActivity() {

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    rvTest.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    //maybe an adapter without content has to be provided so you won't get the error: no adapter attached skipping layout
    rvTest.viewTreeObserver.addOnGlobalLayoutListener(object: ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            rvTest.adapter = RvTestAdapter(this@MainActivity, rvTest.height)
            rvTest.viewTreeObserver.removeOnGlobalLayoutListener(this) //must remove! 
        }

    })
}
}