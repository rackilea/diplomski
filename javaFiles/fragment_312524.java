WorkManager.getInstance(context)
            .enqueueUniquePeriodicWork(
                NotificationWorker.WORKER_TAG,
                ExistingPeriodicWorkPolicy.KEEP,
                notificationWorker
            );