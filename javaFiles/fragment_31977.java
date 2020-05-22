@Override
public void onBackPressed() {
    // if playerTask == null mediaPlayer is never start, no need to handle

    if(playerTask != null && playerTask.getStatus() == AsyncTask.Status.FINISHED) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    } else if (playerTask != null && playerTask.getStatus() != AsyncTask.Status.FINISHED) {
        // It mean your task is running, should stop your mediaPlayer inside your task
        playerTask.cancel(true);
    }
   super.onBackPressed();
}