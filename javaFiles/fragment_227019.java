private void startStatusTimer() {
    if (!wipeOutTimer.isRunning()) {
        wipeOutTimer.start();
    } else {
        wipeOutTimer.restart();
    }