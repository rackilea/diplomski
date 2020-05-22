class MainActivity : AppCompatActivity() {

    @Volatile
    var state : State = State.INACTIVE

    enum class State {
        ACTIVE, INACTIVE, HANDLED
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
    }

    private fun bind() {
        addQuestions()
        addAnswers()
    }

    private fun getRandomColor(): Int {
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
            view.findViewById<View>(R.id.questionView)
                .setOnDragListener(DragListener())
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
        val ITEM_INDEX_D = "Index-From"

        override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
            return if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                createDrag(view)
                true
            } else {
                false
            }
        }

        private fun createDrag(view : View) {
            val parent = view.parent as ViewGroup
            view.tag = Pair(ITEM_INDEX_D,
                parent.indexOfChild(view))

            view.startDragAndDrop(ClipData.newPlainText("", ""),
                DragShadowBuilder(view), view, 0)
            parent.removeView(view)
            parent.setBackgroundColor(Color.WHITE)
        }
    }

    private inner class DragListener : OnDragListener {

        override fun onDrag(parent: View, event: DragEvent): Boolean {
            val view = event.localState as View

            when (event.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    state = State.ACTIVE
                }
                DragEvent.ACTION_DRAG_ENTERED -> {
                }
                DragEvent.ACTION_DRAG_EXITED -> {

                }
                DragEvent.ACTION_DROP -> {
                    state = State.HANDLED
                    animateDropEffect(parent, view)
                    return true
                }
                DragEvent.ACTION_DRAG_ENDED -> {
                    if (state == State.ACTIVE) {
                        state = State.INACTIVE
                        animateMoveBack(view,
                            (view.tag as Pair<*, *>).second as Int)
                    }
                    return true
                }
                else -> {
                }
            }
            return true
        }

        private fun animateMoveBack(view: View, index : Int) {
            answerContainer.addView(view, index)
        }

        private fun animateDropEffect(into: View, view: View) {
            val parent = (into.parent as ViewGroup)
            parent.addView(view)

            val params = (view.layoutParams as FrameLayout.LayoutParams)
                .apply {
                    gravity = Gravity.END
                }
            view.layoutParams = params
            checkIsCorrect(parent)
        }

        private fun checkIsCorrect(parent : ViewGroup) {
            val correct = Random.nextBoolean()

            val colorFrom = Color.WHITE
            val colorTo : Int = if (correct) 0x8000ff00.toInt() else 0x80ff0000.toInt()
            ObjectAnimator.ofObject(
                parent,
                "backgroundColor",
                ArgbEvaluator(),
                colorFrom,
                colorTo
            )
                .setDuration(1000)
                .start()
        }
    }
}