public void playStillSearching() {

    if (handler == null) {
            handler = new Handler();
            handler.postDelayed(runnable = new Runnable() {
                @Override
                public void run() {
                    soundPool.play(stillSearching, 1.0f, 1.0f, 1, 0, 1.0f);
                    handler.postDelayed(this, 3000);
                }
            }, 3000);
    }
}

public void stopSpeak() {

    if (handler != null) {
        handler.removeCallbacks(runnable);
    }
}