class SaxHandler {
   SaxProxy proxy = new SaxProxyImpl();
   public void startElement(e) {
      proxy.startElement(e);
   }
}