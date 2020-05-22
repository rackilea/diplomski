long curTime = System.currentTimeMillis();

while (wakeUpTime - curTime > 0) {
  try {
    Thread.sleep(wakeUpTime - curTime);
  } catch (InterruptedException ex) { }
  curTime = System.currentTimeMillis();
}