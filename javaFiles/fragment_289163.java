class MainActivity : AppCompatActivity() {

    var activeOneDrag : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
    }

    private fun bind() {
        addQuestions()
        addAnswers()
    }

    fun getRandomColor(): Int {
        return Color.argb(255, Random.nextInt(255),
            Random.nextInt(255), Random.nextInt(255))
    }

    @SuppressLint("InflateParams")
    private fun addQuestions() {
        val inflater = getSystemService(
            Context.LAYOUT_INFLATER_SERVICE
        ) as LayoutInflater
        for (i in 1..8) {
            val view = inflater.inflate(R.layout.item_question, null)
            view.setOnDragListener(DragListener())
            questionContainer.addView(view)
        }
    }


    @SuppressLint("InflateParams")
    private fun addAnswers() {
        val inflater = getSystemService(
            Context.LAYOUT_INFLATER_SERVICE
        ) as LayoutInflater
        for (i in 1..8) {
            val view = inflater.inflate(R.layout.item_answer, null)
            (view as ViewGroup).getChildAt(0).setBackgroundColor(getRandomColor())
            view.setOnTouchListener(DragItemTouchListener())
            answerContainer.addView(view)
        }
    }


    private inner class DragItemTouchListener : OnTouchListener {

        override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
            return if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                dragMultiple(view)
                true
            } else {
                false
            }
        }

        private fun dragMultiple(view : View) {
            val parent = view.parent as ViewGroup
            parent.removeView(view)
            /**
             * Some other logic with selective multiple View.
             * Just getting neighbor in our case
             */

            var anotherView : View? = null
            if (!activeOneDrag) {
                anotherView = parent.getChildAt(
                    parent.indexOfChild(view) + 1)
                parent.removeView(anotherView)
            }
            activeOneDrag = !activeOneDrag

            /**
             * As you can see, there is postDelay here.
             * But only for our case with animateLayoutChanges,
             * with delays removing View! In your samples, you could remove it
             * with listener on your own animation, if any!
             */
            parent.postDelayed({

                val layout = LinearLayout(this@MainActivity)
                val params = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT)
                params.gravity = Gravity.BOTTOM
                layout.layoutParams = params
                layout.orientation = LinearLayout.HORIZONTAL


                layout.addView(view)
                if (anotherView != null) {
                    layout.addView(anotherView)
                }
                layout.visibility = INVISIBLE
                mainContainer.addView(layout)

                parent.post {
                    layout.startDragAndDrop(
                        ClipData.newPlainText("", ""),
                        DragShadowBuilder(layout), layout, 0)
                }

            }, 400)

        }
    }


    private inner class DragListener : OnDragListener {

        override fun onDrag(v: View, event: DragEvent): Boolean {
            when (event.action) {
                DragEvent.ACTION_DRAG_STARTED -> {

                }
                DragEvent.ACTION_DRAG_ENTERED -> {

                }
                DragEvent.ACTION_DRAG_EXITED -> {

                }
                DragEvent.ACTION_DROP -> {
                    val view = event.localState as View
                    (view.parent as ViewGroup).removeView(view)
                    view.visibility = VISIBLE
                    animateDropEffect(v as ViewGroup, event.localState as View)
                }
                DragEvent.ACTION_DRAG_ENDED -> {

                }
                else -> {
                }
            }
            return true
        }

        private fun animateDropEffect(into: ViewGroup, view: View) {
            into.addView(view)
            val params = (view.layoutParams as FrameLayout.LayoutParams)
                .apply {
                    gravity = Gravity.END
                }
            view.layoutParams = params
        }
    }
}