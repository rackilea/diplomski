class MainActivity : AppCompatActivity() {

    enum class State {
        ACTIVE, INACTIVE, HANDLED
    }

    var state : State = State.INACTIVE

    var failsCount = 0

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
        for (i in 1..3) {
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
        for (i in 1..3) {
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

        val ANIM_DURATION_LONG = TimeUnit.SECONDS.toMillis(1)
        val ANIM_DURATION_SHORT = TimeUnit.MILLISECONDS.toMillis(500)

        val GREEN_ALPHA = 0x8000ff00.toInt()
        val RED_ALPHA = 0x80ff0000.toInt()
        val ANIM_COLOR = "backgroundColor"

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
            val correct = false
            if (correct) {
                animateColorChange(parent, true)
                return
            }
            if (++failsCount > Companion.MAX_FAIL_COUNT) {
                animateColorChange(parent, false)
                return
            }
            animateWrongAttempt(parent)
        }

        private fun animateWrongAttempt(parent: ViewGroup) {
            val questionMark = parent.findViewById<View>(R.id.questionView)
            questionMark.setBackgroundColor(Color.RED)

            val va = ValueAnimator.ofFloat(1f, 1.1f)
            va.interpolator = BounceInterpolator()

            va.duration = ANIM_DURATION_SHORT
            va.addUpdateListener { animation ->
                questionMark.scaleX = animation.animatedValue as Float
                questionMark.scaleY = animation.animatedValue as Float
            }
            va.start()

        }

        private fun animateColorChange(parent : ViewGroup, right : Boolean) {
            val colorFrom = Color.WHITE
            ObjectAnimator
                .ofObject(parent, ANIM_COLOR,
                    ArgbEvaluator(), colorFrom,
                    if (right) GREEN_ALPHA else RED_ALPHA)
                .setDuration(ANIM_DURATION_LONG)
                .start()
        }
    }

    companion object {
        const val MAX_FAIL_COUNT = 2
    }
}