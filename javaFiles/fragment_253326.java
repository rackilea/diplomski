if (running) {
        runPauseButton.setText("Run");
        synchronized (mLock) {
           running = false;
        }

    }
    if (!running) {
        runPauseButton.setText("Pause");
        synchronized (mLock) {
            running = true;
            mLock.notify();
        }
    }