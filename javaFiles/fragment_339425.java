@Rule @JvmField
val activityRule: IntentsTestRule<MainActivity> =
        object : IntentsTestRule<MainActivity>(MainActivity::class.java, true, false) {
            override fun beforeActivityLaunched() {
                super.beforeActivityLaunched()
                Intents.init()
                intending(hasComponent(LaunchedFromOnCreateActivity::class.java.name)).respondWith(Instrumentation.ActivityResult(RESULT_OK, null))
            }
            override fun afterActivityLaunched() {
                Intents.release()
                super.afterActivityLaunched()
            }
        }