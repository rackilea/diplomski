switch (currentStatus) {
case PAUSED:
case STOPPED:
    animation.playFromStart();
    break;
case RUNNING:
    animation.stop();
}