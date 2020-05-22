public static void main(String args[]) {
  try {
    doStuff();
  } catch (Throwable e) {
    e.printStackTrace();
    logStuff(e);
  }
}