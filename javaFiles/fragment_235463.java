ActiveXObject ao1 = null;
ActiveXObject ao2 = null;
ComThread.initMTA();
try {
  ao1 = new ActiveXObject("blaa.blaa");
  ao2 = new ActiveXObject("haa.haa");
  // business logic
} finally {
  if (ao1 != null) {
    ao1.safeRelease();
    ao1 = null;
  }
  if (ao2 != null) {
    ao2.safeRelease();
    ao2 = null;
  }
  ComThread.Release();
}