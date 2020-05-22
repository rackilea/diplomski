val restartThread = Thread {
    logger.info("Restarting...")
    Thread.sleep(1000)
    SpringMain.restartToMode(AppMode.valueOf(change.newMode.toUpperCase()))
    logger.info("Restarting... Done.")
}
restartThread.isDaemon = false
restartThread.start()