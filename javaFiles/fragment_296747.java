for(;;) {
  if (timerTask.getCount() == 5) {
    timer.cancel();
    break;
  } else{
    Thread.yield();
  }
}