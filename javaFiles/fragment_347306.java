class EasyFieldAlterationAgent {
  public static void premain(String args) throws Exception {
    Field field = X.class.getDeclaredField("timeout");
    field.setAccessible(true);
    field.setValue(null, 42L); // set your value here.
  }
}