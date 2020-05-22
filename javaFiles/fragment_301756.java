class MyWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
            // DO WORK HERE

            Result.success()
        } else {
            // HANDLE FAILURE HERE
            Result.failure()
        }