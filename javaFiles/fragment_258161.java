class Presenter(private val repo: Repository,
            private val uiContext: CoroutineContext = Dispatchers.Main
) : CoroutineScope { // creating local scope

    private var job: Job = Job()

    // To use Dispatchers.Main (CoroutineDispatcher - runs and schedules coroutines) 
    // in Android add dependency: implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.0.1'
    override val coroutineContext: CoroutineContext
        get() = uiContext + job

    fun detachView() {
        // cancel the job when view is detached
        job.cancel()
    }

    fun login(request: LoginRequest) = launch { // launching a coroutine
        val result = repo.loginUser(request) // calling 'loginUser' function will not block the Main Thread, it suspends the coroutine

        //use result, update UI
        when (result) {
            is Success<LoginResponse> -> { /* update UI when login success */ } 
            is Error -> { /* update UI when login error */ }
        }
    }
}