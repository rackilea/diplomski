private static frmMain instance = null;

public static frmMain getInstance() {
  if (instance == null) {
    instance = new frmMain();
  }
  return instance;
}