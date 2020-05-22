if (running) {
        runPauseButton.setText("Run");
        synchronized (mLock) {
           running = false;
        }
    } else {
        runPauseButton.setText("Pause");
        synchronized (mLock) {
            running = true;
            mLock.notify();
        }
    }