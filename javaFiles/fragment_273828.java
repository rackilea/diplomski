private fun init() {


    mPager = findViewById(R.id.pager) as ViewPager
    mPager!!.adapter = SlidingImage_Adapter(this@MainActivity, this.imageModelArrayList!!)

    val indicator = findViewById(R.id.indicator) as CirclePageIndicator

    indicator.setViewPager(mPager)

    val density = resources.displayMetrics.density

    //Set circle indicator radius
    indicator.setRadius(5 * density)

    NUM_PAGES = imageModelArrayList!!.size

    // Auto start of viewpager
    val handler = Handler()
    val Update = Runnable {
        if (currentPage == NUM_PAGES) {
            currentPage = 0
        }
        mPager!!.setCurrentItem(currentPage++, true)
    }
    val swipeTimer = Timer()
    swipeTimer.schedule(object : TimerTask() {
        override fun run() {
            handler.post(Update)
        }
    }, 3000, 3000)

    // Pager listener over indicator
    indicator.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {

        override fun onPageSelected(position: Int) {
            currentPage = position

        }

        override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {

        }

        override fun onPageScrollStateChanged(pos: Int) {

        }
    })

}

companion object {

    private var mPager: ViewPager? = null
    private var currentPage = 0
    private var NUM_PAGES = 0
}