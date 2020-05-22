Animation.Status currentStatus = animation.getStatus();
if (currentStatus == PAUSED || currentStatus == STOPPED) {
    animation.playFromStart();
} else if (currentStatus == RUNNING) {
    animation.stop();
}