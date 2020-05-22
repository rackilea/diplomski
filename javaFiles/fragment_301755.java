override fun beginWork() {

        val periodicWorkRequest = PeriodicWorkRequest.Builder(
                MyWorker::class.java,
                REPEAT_INTERVAL, TimeUnit.MINUTES, // How often work should repeat
                // Flex not required.
                FLEX_INTERVAL, TimeUnit.MINUTES) // Limits execution into a time window
                .setConstraints(
                     Constraints.Builder().setRequiredNetworkType(
                                       NetworkType.CONNECTED).build())
                .addTag(MY_WORKER_TAG)
                .build()

        WorkManager.getInstance().enqueueUniquePeriodicWork(
                MY_UNIQUE_WORK,
                ExistingPeriodicWorkPolicy.KEEP,
                periodicLoginRequest)