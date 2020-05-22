class MyServlet extends javax.servlet.GenericServlet {
  private NativeWrapper nativeWrapper = new NativeWrapper();

  public void someServletMethod() {
    nativeWrapper.callNative();
  }
}