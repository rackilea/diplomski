@Override
public void onFinish() {
    started = false;
    Intent tickIntent = new Intent(ACTION_COMPLETE);
    LocalBroadcastManager.getInstance(PomodoroService.this).sendBroadcast(tickIntent);
    Log.i("TIMER", "countdown Finished()");
    lock.lock();
    try {
        waitForFinish.signal();
    } finally {
        lock.unlock();
    }
}