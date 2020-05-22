while (true) {
  Thread.sleep(500);
  if (isCollided) {
  clip.stop();
  thread.interupt();
  }
}