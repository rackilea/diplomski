class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
    }

    private fun bind() {
        addQuestions()
        addAnswers()
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
            val data = ClipData.newPlainText("", "")
            val shadowBuilder = DragShadowBuilder(
                view
            )
            val parent = view.parent as ViewGroup

            view.startDragAndDrop(data, shadowBuilder, view, 0)
            parent.removeView(view)
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